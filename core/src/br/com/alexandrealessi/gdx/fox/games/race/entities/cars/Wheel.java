package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by alex on 02/05/2015.
 */
public class Wheel extends GameObject implements Accelerable {
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
//        body.setAngularVelocity(amount * direction);

    }

    @Override
    public void brek(float amount) {

    }

    public float getRadius() {
        return body.getRadius(0);
    }

    /**
     *
     * @return Angular Velocity in Radians/Second
     */
    int i = 0;
    public float getAngularVelocity (){
        if (i++ % 60 == 0){
            System.out.println();
            System.out.println("linear: "+ Math.abs(body.getLinearVelocity().x));

            System.out.println("angular: "+Math.abs(body.getAngularVelocity()));
        }
        return body.getAngularVelocity();

    }

}
