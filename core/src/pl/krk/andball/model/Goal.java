package pl.krk.andball.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import pl.krk.andball.AndBallGame;

public class Goal {

    private boolean isGoal;
    private World world;
    private GoalSide side;

    public Goal(World world, GoalSide side) {

        this.world = world;
        this.side = side;

        createGoalBody();
    }

    private void createGoalBody() {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        Body body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();

        Vector2[] points = new Vector2[2];
        if(side == GoalSide.LEFT) {
            points[0] = new Vector2(1 / AndBallGame.PPM, 465 / AndBallGame.PPM);
            points[1] = new Vector2(1 / AndBallGame.PPM, 615 / AndBallGame.PPM);
        } else {
            points[0] = new Vector2(1920 / AndBallGame.PPM, 465 / AndBallGame.PPM);
            points[1] = new Vector2(1920 / AndBallGame.PPM, 615 / AndBallGame.PPM);
        }
        ChainShape chainShape = new ChainShape();
        chainShape.createChain(points);

        fixtureDef.shape = chainShape;
        body.createFixture(fixtureDef).setUserData(this);

    }

    public boolean isGoal() {
        return isGoal;
    }

    public void setGoal(boolean goal) {
        isGoal = goal;
    }

    public enum GoalSide{
        LEFT, RIGHT
    }
}
