package br.com.alexandrealessi.gdx.fox.soccer;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import com.badlogic.gdx.Gdx;

/**
 * Created by alexandre on 21/04/15.
 */
public class SoccerGame extends BaseGame {

    String tag = SoccerGame.class.getName();
    public SoccerGame(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {
        setScreen(new SoccerGameScreen(this));
        Gdx.app.log(tag, "create");
    }

}
