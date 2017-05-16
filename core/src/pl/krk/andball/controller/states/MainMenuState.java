package pl.krk.andball.controller.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.krk.andball.AndBallGame;

/**
 * Created by dziadziasmerf on 17.04.17.
 */
public class MainMenuState extends State{

    Texture backgroud;
    Texture startButton;

    public MainMenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        backgroud = new Texture("field.png");
        startButton = new Texture("play.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gameStateManager.set(new MatchState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(backgroud,0,0, AndBallGame.WIDTH, AndBallGame.HEIGHT);
        spriteBatch.draw(startButton, ((AndBallGame.WIDTH/2) - (startButton.getWidth()/2)), ((AndBallGame.HEIGHT / 2) - (startButton.getHeight() / 2)));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        backgroud.dispose();
        startButton.dispose();
    }
}
