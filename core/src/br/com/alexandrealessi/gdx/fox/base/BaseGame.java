package br.com.alexandrealessi.gdx.fox.base;

import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by alexandre on 25/04/15.
 */
public class BaseGame extends ApplicationAdapter {

    protected RequestHandler requestHandler;

    protected BaseGame(RequestHandler requestHand) {
        this.requestHandler = requestHand;
    }




}
