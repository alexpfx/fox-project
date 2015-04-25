package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.Game;

public abstract class BaseGame extends Game {

    protected RequestHandler requestHandler;

    protected BaseGame(RequestHandler requestHand) {
        this.requestHandler = requestHand;
    }

}
