package pl.krk.andball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.krk.andball.controller.states.GameStateManager;
import pl.krk.andball.controller.states.MainMenuState;

public class AndBallGame extends ApplicationAdapter {

	public static final String name = "AndBall";
	public static final int HEIGHT = 1080;
	public static final int WIDTH = 1920;
	public static int PPM = 20;
	private GameStateManager gameStateManager;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		gameStateManager.push(new MainMenuState(gameStateManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
