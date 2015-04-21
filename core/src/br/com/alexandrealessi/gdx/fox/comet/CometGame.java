package br.com.alexandrealessi.gdx.fox.comet;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;

/**
 * Created by alexandre on 21/04/15.
 */
public class CometGame extends BaseGame {
    protected CometGame(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {
        setScreen(new CometGameScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }
}
