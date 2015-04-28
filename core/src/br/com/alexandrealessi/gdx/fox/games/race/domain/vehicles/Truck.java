package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/04/15.
 */
public abstract class Truck implements Vehicle{



    Array<VehicleComponent> rearWheels;

    VehicleComponent frontWheel;
    VehicleComponent trailer;
    VehicleComponent Tractor;



    @Override
    public final Array<VehicleComponent> getComponents() {
        //TODO implementar.
        return null;
    }
}
