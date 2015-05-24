package br.com.alexandrealessi.gdx.fox.games.soccer;

import br.com.alexandrealessi.gdx.fox.games.soccer.screens.MainMenuScreen;
import com.badlogic.gdx.Game;

/**
 * Created by alexandre on 22/05/15.
 */
public class SoccerGame extends Game {


    @Override
    public void create() {
        setScreen(new MainMenuScreen());

    }
}
