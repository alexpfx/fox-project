package br.com.alexandrealessi.gdx.fox.comet;

import br.com.alexandrealessi.gdx.fox.base.BaseGameOld;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import com.badlogic.gdx.Gdx;

/**
 * Created by alexandre on 21/04/15.
 */
public class CometGameOld extends BaseGameOld {
    private String tag = CometGameOld.class.getName();

    public CometGameOld(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {

        setScreen(new CometGameScreen(this));
        Gdx.app.log(tag, "create");


    }
}
