package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.Game;

public abstract class BaseGameOld extends Game {

    protected RequestHandler requestHandler;

    protected BaseGameOld(RequestHandler requestHand) {
        this.requestHandler = requestHand;
    }

}
