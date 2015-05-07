package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;

/**
 * Created by alex on 02/05/2015.
 */

public class Chassis extends GameObject{

    public Chassis(RigidBody rigidBody) {
        super(rigidBody);
    }

    public Chassis(RigidBody body, Drawable drawable) {
        super(body, drawable);
    }
}
