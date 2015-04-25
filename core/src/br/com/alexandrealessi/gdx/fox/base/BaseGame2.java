package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.ApplicationAdapter;

/**
 * Created by alexandre on 25/04/15.
 */
public class BaseGame2 extends ApplicationAdapter {

    protected RequestHandler requestHandler;

    protected BaseGame2(RequestHandler requestHand) {
        this.requestHandler = requestHand;
    }

}
