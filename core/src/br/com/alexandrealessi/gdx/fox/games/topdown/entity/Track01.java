package br.com.alexandrealessi.gdx.fox.games.topdown.entity;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.GameObject;

/**
 * Created by alexandre on 16/05/15.
 */
public class Track01 extends GameObject {

    {
        setObjectName("track01");
    }

    public Track01(RigidBody body, Drawable drawable) {
        super(body, drawable);
    }
}
