package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;

/**
 * Created by alex on 02/05/2015.
 */

public class Chassis extends GameObject{

    {
        setObjectName("chassis");
    }
    public Chassis(RigidBody rigidBody) {
        super(rigidBody);

    }

    public Chassis(RigidBody body, Drawable drawable) {
        super(body, drawable);
    }


    public void applyAngularImpulse (float amount, float direction){
        body.applyAngularImpulse(amount * direction, true);
    }

    public void applyLinearImpulse (float x, float y){
        body.applyLinearImpulse(x,y);
    }


}
