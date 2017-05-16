package pl.krk.andball.controller.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.krk.andball.AndBallGame;
import pl.krk.andball.controller.Joystick;
import pl.krk.andball.controller.listeners.MatchCollisionListener;
import pl.krk.andball.model.Ball;
import pl.krk.andball.model.Field;
import pl.krk.andball.model.Goal;
import pl.krk.andball.model.Player;

public class MatchState extends State {

    private Texture background;
    private Texture goalTexture;
    private Goal leftGoal;
    private Goal rightGoal;
    private Player player;
    private Ball ball;
    private Field field;
    private Joystick joystick;
    private World world;
    private Stage stage;
    private Box2DDebugRenderer box2DDebugRenderer;

    public MatchState(GameStateManager gameStateManager) {
        super(gameStateManager);

        world = new World(new Vector2(0, 0), true);
        world.setContactListener(new MatchCollisionListener());

        box2DDebugRenderer = new Box2DDebugRenderer();

        player = new Player(world);
        ball = new Ball(world);
        leftGoal = new Goal(world, Goal.GoalSide.LEFT);
        rightGoal = new Goal(world, Goal.GoalSide.RIGHT);
        field = new Field(world);

        background = new Texture("field.png");
        goalTexture = new Texture("goal.png");
        stage = new Stage();

        joystick = Joystick.getJoystic();
        stage.addActor(joystick);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void handleInput() {
        if ((Gdx.input.isKeyJustPressed(Input.Keys.X) || Gdx.input.justTouched()) && player.isTouchingBall()) {
            ball.b2body.applyLinearImpulse(new Vector2(ball.b2body.getPosition().sub(player.b2body.getPosition()).scl(3)), ball.b2body.getWorldCenter(), true);
        }
        if (leftGoal.isGoal() && Gdx.input.justTouched()) {
            leftGoal.setGoal(false);
            resetPositions();

        }if (rightGoal.isGoal() && Gdx.input.justTouched()) {
            rightGoal.setGoal(false);
            resetPositions();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        player.b2body.applyForceToCenter(joystick.getKnobPercentX() * 10, joystick.getKnobPercentY() * 10, true);
        player.update(dt);
        ball.update(dt);
        world.step(1 / 60f, 6, 2);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, AndBallGame.WIDTH / AndBallGame.PPM, AndBallGame.HEIGHT / AndBallGame.PPM);
        ball.draw(spriteBatch);
        player.draw(spriteBatch);
        if (leftGoal.isGoal() || rightGoal.isGoal())
            spriteBatch.draw(goalTexture, 760 / AndBallGame.PPM, 900 / AndBallGame.PPM, 400 / AndBallGame.PPM, 142 / AndBallGame.PPM);

        spriteBatch.end();

//        box2DDebugRenderer.render(world, camera.combined);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
    }

    private void resetPositions() {
        player.resetPosition();
        ball.resetPosition();
    }

}
