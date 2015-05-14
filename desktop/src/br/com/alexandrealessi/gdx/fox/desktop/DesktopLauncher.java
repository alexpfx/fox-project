package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.base.test.GdxTest;
import br.com.alexandrealessi.gdx.fox.base.test.PathTest;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.race.RaceGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    static boolean runtest = false;
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1920;
        config.height = 1080;
        if (runtest){
            runTest("Path");
            return;
        }
        try{
            new LwjglApplication(new RaceGame(RequestHandler.NULL), config);
        } finally {

        }
    }

    public static boolean runTest (String testName) {
        GdxTest test = new PathTest();
        if (test == null) {
            return false;
        }
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 640;
        config.height = 480;
        config.title = testName;
        config.forceExit = false;
        new LwjglApplication(test, config);
        return true;
    }
}
