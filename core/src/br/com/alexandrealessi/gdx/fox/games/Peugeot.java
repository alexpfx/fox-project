package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.entities.BodyName;

/**
 * Created by alex on 02/05/2015.
 */
public class Peugeot extends NewCar {

    private Wheel frontWheel, rearWheel;
    private Chassis chassis;

    @BodyName(bodyNameReference = "peugeot_front_wheel")
    @Override
    Wheel getFrontWheel() {
        return frontWheel;
    }


    @BodyName(bodyNameReference = "peugeot_rear_wheel")
    @Override
    Wheel getRearWheel() {
        return rearWheel;
    }


    @BodyName(bodyNameReference = "peugeot_chassis")
    @Override
    Chassis getChassis() {
        return chassis;
    }
}
