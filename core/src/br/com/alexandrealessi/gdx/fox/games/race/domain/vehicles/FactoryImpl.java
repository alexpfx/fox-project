package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.base.components.theather.ActorComponent;
import br.com.alexandrealessi.gdx.fox.base.components.theather.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeScene;

/**
 * Created by alexandre on 28/04/15.
 */
//TODO: mudar nome
public class FactoryImpl implements Factory{

    private final RubeSceneWrapper rubeScene;

    public FactoryImpl(RubeScene scene) {
        rubeScene = new RubeSceneWrapper(scene);
    }

    //Considerar peças terem subpeças.
    //Ver como fica objetos compostos em relação a física, fixtures, joints, etc.
    //Criar uma interface geral e construir ela, nao vehicle
    @Override
    public CompositeActor construct(Vehicle vehicle) {
        CompositeActor actor = new CompositeActor();
        for (VehicleComponent component:vehicle.getComponents()){
            final String bodyName = component.getDescriptor().bodyName();
            //setScript
            ActorComponent actorComponent = new ActorComponent() ;
            final Body body = rubeScene.getBody(bodyName);
            final String bindedImageFileName = rubeScene.getBindedImageFileName(body);
        }
        return actor;
    }
}
