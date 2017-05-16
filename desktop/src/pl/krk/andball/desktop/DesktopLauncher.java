package pl.krk.andball.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sun.org.apache.xpath.internal.operations.And;
import pl.krk.andball.AndBallGame;
import pl.krk.andball.controller.states.MatchState;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = AndBallGame.WIDTH;
		config.height = AndBallGame.HEIGHT;
		config.title = AndBallGame.name;
		new LwjglApplication(new AndBallGame(), config);
	}
}
