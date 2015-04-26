package br.com.alexandrealessi.gdx.fox.soccer;

import br.com.alexandrealessi.gdx.fox.base.BaseGameOld;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import com.badlogic.gdx.Gdx;

/**
 * Created by alexandre on 21/04/15.
 */
public class SoccerGameOld extends BaseGameOld {

    String tag = SoccerGameOld.class.getName();
    public SoccerGameOld(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {
        setScreen(new SoccerGameScreen(this));
        Gdx.app.log(tag, "create");
    }

}
