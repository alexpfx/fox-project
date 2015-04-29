package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles;

import br.com.alexandrealessi.gdx.fox.base.components.ImageDrawable;
import br.com.alexandrealessi.gdx.fox.base.components.theather.Actor;
import br.com.alexandrealessi.gdx.fox.base.components.theather.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.CarsGameConstants;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeScene;

/**
 * Created by alexandre on 28/04/15.
 */
//TODO: mudar nome
public class FactoryImpl implements Factory {

    private final RubeSceneWrapper rubeScene;
    private final ResourceManager resourceManager;

    public FactoryImpl(RubeSceneWrapper scene, ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        this.rubeScene = scene;
    }

    //Considerar peças terem subpeças.
    //Ver como fica objetos compostos em relação a física, fixtures, joints, etc.
    //Criar uma interface geral e construir ela, nao vehicle
    @Override
    public CompositeActor construct(Vehicle vehicle) {

        CompositeActor compositeActor = new CompositeActor();
        for (VehicleComponent component : vehicle.getComponents()) {
            final String bodyName = component.getDescriptor().bodyName();
            final Body body = rubeScene.getBody(bodyName);
            Actor actor = new Actor(body);
            final String bindedImageFileName = rubeScene.getBindedImageFileName(body);
            final ImageDrawable imageDrawable = ImageDrawable.createFromTextureRegion(getRegionBy(bindedImageFileName));
            actor.setDrawable(imageDrawable);
            compositeActor.addChild(actor);
        }
        return compositeActor;
    }

    public TextureRegion getRegionBy(String name) {
        return resourceManager.getRegion(CarsGameConstants.Strings.GAME_ATLAS_NAME.value, name);
    }

}
