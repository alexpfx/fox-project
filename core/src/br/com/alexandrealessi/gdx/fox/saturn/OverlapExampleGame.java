package br.com.alexandrealessi.gdx.fox.saturn;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;

/**
 * Created by alexandre on 23/04/15.
 */
public class OverlapExampleGame extends BaseGame {

    public OverlapExampleGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        setScreen(new OverlapExampleScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }
}
