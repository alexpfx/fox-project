package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.entities.BodyName;
import br.com.alexandrealessi.gdx.fox.base.entities.DrawableName;

/**
 * Created by alex on 02/05/2015.
 */
public class Peugeot extends NewCar {

    private Wheel frontWheel, rearWheel;
    private Chassis chassis;

    public Peugeot (){
        frontWheel = new Wheel();
        rearWheel = new Wheel();
        chassis = new Chassis();
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_front_wheel")
    @BodyName(bodyNameReference = "peugeot_front_wheel")
    @Override
    Wheel getFrontWheel() {
        return frontWheel;
    }


    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_rear_wheel")
    @BodyName(bodyNameReference = "peugeot_rear_wheel")
    @Override
    Wheel getRearWheel() {
        return rearWheel;
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_chassis")
    @BodyName(bodyNameReference = "peugeot_chassis")
    @Override
    Chassis getChassis() {
        return chassis;
    }
}
