package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.base.components.CompositeActor;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;

/**
 * Created by alexandre on 28/04/15.
 */
//TODO: mudar nome
public class FactoryImpl implements Factory{

    //Considerar pe�as terem subpe�as.
    //Ver como fica objetos compostos em rela��o a f�sica, fixtures, joints, etc.
    @Override
    public CompositeActor construct(Vehicle vehicle) {
        CompositeActor actor = new CompositeActor();
        for (VehicleComponent component:vehicle.getComponents()){
            component.getDescriptor().bodyName();
            component.getDescriptor().drawableName();
        }
        return actor;
    }
}
