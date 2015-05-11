package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alex on 02/05/2015.
 */
public class Wheel extends GameObject implements Accelerable{
    {
        setObjectName("wheel");
    }
    public Wheel(RigidBody body) {
        super(body);


    }

    public Wheel(RigidBody body, Drawable drawable) {
        super(body, drawable);
    }


    @Override
    public void accelerate(float amount, float direction) {
        body.applyAngularImpulse(amount * direction, true);

    }

    @Override
    public void brek(float amount) {

    }

    @Override
    public Vector2 getVelocity() {
        return Vector2.Zero.set(body.getAngularVelocity(),0);
    }
}
