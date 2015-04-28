package br.com.alexandrealessi.gdx.fox.games.race.actors;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/04/15.
 */
public abstract class Car implements IVehicle {

    private final Chassis chassi;
    private final FrontWheel frontWheel;
    private final RearWheel rearWheel;

    protected Car(Chassis chassi, FrontWheel frontWheel, RearWheel rearWheel) {
        this.chassi = chassi;
        this.frontWheel = frontWheel;
        this.rearWheel = rearWheel;
    }

    @Override
    public Array<IVehicleComponent> getComponents() {
        return Array.with((IVehicleComponent) chassi, (IVehicleComponent) frontWheel, (IVehicleComponent) rearWheel);
    }
}
