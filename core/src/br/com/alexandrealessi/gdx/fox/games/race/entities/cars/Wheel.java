package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;

/**
 * Created by alex on 02/05/2015.
 */
public class Wheel extends DefaultEntity implements Accelerable{

    @Override
    public void accelerate(float amount, float direction) {
        getBody().applyAngularImpulse(amount * direction, true);
        System.out.println(getBody().getLinearVelocity().x * 3.6f);

    }

    @Override
    public void brek(float amount) {

    }
}
