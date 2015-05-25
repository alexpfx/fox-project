package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.base.test.GdxTest;
import br.com.alexandrealessi.gdx.fox.base.test.PathTest;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.race.RaceGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.topdown.TopDownRaceGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

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
            pack();
//            new LwjglApplication(new RaceGame(RequestHandler.NULL), config);
            new LwjglApplication(new SoccerGame(), config);
//            new LwjglApplication(new TopDownRaceGame(RequestHandler.NULL), config);
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

    public static void pack (){
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 4096;
        settings.maxHeight = 2048;
        TexturePacker.process(settings, "../../assets-raw/animals", "data/images/", "game.atlas");
    }
}


