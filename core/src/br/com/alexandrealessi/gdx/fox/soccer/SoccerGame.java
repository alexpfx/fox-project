package br.com.alexandrealessi.gdx.fox.soccer;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;

/**
 * Created by alexandre on 21/04/15.
 */
public class SoccerGame extends BaseGame {

    public SoccerGame(RequestHandler requestHand) {
        super(requestHand);

    }

    @Override
    public void create() {
        setScreen(new SoccerGameScreen(this));

    }

    @Override
    public void render() {
        super.render();

    }
}
