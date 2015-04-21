package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import br.com.alexandrealessi.gdx.fox.soccer.SoccerGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SoccerGame(RequestHandler.NULL), config);
	}
}
