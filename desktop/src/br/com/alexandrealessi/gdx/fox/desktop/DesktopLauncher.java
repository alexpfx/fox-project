package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import br.com.alexandrealessi.gdx.fox.car.CarsGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 480;
//		new LwjglApplication(new OverlapExampleGame(RequestHandler.NULL), config);
        new LwjglApplication(new CarsGame(RequestHandler.NULL), config);
    }
}
