package br.com.alexandrealessi.gdx.fox.desktop;

import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
    static boolean pack = true;
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1920;
        config.height = 1080;
        try{
            if (pack) {
                pack();
            }
            new LwjglApplication(new SoccerGame(), config);
        } finally {

        }
    }


    public static void pack (){
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 4096;
        settings.maxHeight = 2048;
        TexturePacker.process(settings, "../../assets-raw/animals", "data/images/", "game.atlas");
    }
}


