package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.maps.Map;

/**
 * Created by alexandre on 10/05/15.
 */
public interface GameStatusListener {
    public interface GameStatus {
        Map getStatus ();
    }

    void statusChange (GameStatus status);



}
