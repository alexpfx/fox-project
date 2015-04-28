package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 26/04/15.
 */
public interface Vehicle {
    Array<VehicleComponent> getComponents();
}
