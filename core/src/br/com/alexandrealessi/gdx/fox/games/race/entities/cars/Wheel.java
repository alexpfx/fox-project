package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;

/**
 * Created by alex on 02/05/2015.
 */
public class Wheel extends GameObject implements Accelerable{

    public Wheel(RigidBody body) {
        super(body);
    }

    @Override
    public void accelerate(float amount, float direction) {

    }

    @Override
    public void brek(float amount) {

    }
}
