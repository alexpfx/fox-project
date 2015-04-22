package br.com.alexandrealessi.gdx.fox.comet;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import com.badlogic.gdx.Gdx;

/**
 * Created by alexandre on 21/04/15.
 */
public class CometGame extends BaseGame {
    private String tag = CometGame.class.getName();

    public CometGame(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {

        setScreen(new CometGameScreen(this));
        Gdx.app.log(tag, "create");


    }
}
