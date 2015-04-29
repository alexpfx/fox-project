package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.base.components.theather.CompositeActor;

/**
 * Created by alexandre on 28/04/15.
 */
public interface Factory {


    public CompositeActor construct(Vehicle vehicle);
}
