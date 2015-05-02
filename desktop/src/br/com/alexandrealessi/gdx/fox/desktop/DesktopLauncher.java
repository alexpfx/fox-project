package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.CarsGame;
import br.com.alexandrealessi.gdx.fox.games.NewCarsGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 480;
//		new LwjglApplication(new OverlapExampleGame(RequestHandler.NULL), config);
//        new LwjglApplication(new CarsGame(RequestHandler.NULL), config);
        new LwjglApplication(new NewCarsGame(RequestHandler.NULL), config);
    }
}
