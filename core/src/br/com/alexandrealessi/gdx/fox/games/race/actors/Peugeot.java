package br.com.alexandrealessi.gdx.fox.games.race.actors;

/**
 * Created by alexandre on 27/04/15.
 */
public class Peugeot implements ICar {

    @Override
    public IVehicleComponent getChassis() {
        return new Chassis("chassis_peugeot_body", "chassis_peugeot_image");
    }

    @Override
    public IVehicleComponent getRearWheel() {
        return null;
    }

    @Override
    public IVehicleComponent getFrontWheel() {
        return null;
    }
}
