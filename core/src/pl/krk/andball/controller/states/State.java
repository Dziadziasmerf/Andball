package pl.krk.andball.controller.states;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.sun.org.apache.xpath.internal.operations.And;
import pl.krk.andball.AndBallGame;

/**
 * Created by dziadziasmerf on 17.04.17.
 */
public abstract class State{

    protected GameStateManager gameStateManager;
    protected OrthographicCamera camera;

    protected State(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, AndBallGame.WIDTH/AndBallGame.PPM, AndBallGame.HEIGHT/AndBallGame.PPM);
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}
