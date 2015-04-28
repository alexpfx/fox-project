package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.Chassis;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.FrontWheel;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.RearWheel;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.VehicleComponent;
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
