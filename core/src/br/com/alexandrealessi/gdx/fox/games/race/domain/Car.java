package br.com.alexandrealessi.gdx.fox.games.race.domain;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/04/15.
 */
public abstract class Car implements Vehicle {

    private final Chassis chassi;
    private final FrontWheel frontWheel;
    private final RearWheel rearWheel;

    protected Car(Chassis chassi, FrontWheel frontWheel, RearWheel rearWheel) {
        this.chassi = chassi;
        this.frontWheel = frontWheel;
        this.rearWheel = rearWheel;
    }

    @Override
    public final Array<VehicleComponent> getComponents() {
        return Array.with((VehicleComponent) chassi, (VehicleComponent) frontWheel, (VehicleComponent) rearWheel);
    }
}
