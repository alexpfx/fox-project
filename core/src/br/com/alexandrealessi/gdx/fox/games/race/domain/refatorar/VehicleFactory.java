package br.com.alexandrealessi.gdx.fox.games.race.domain.refatorar;

import br.com.alexandrealessi.gdx.fox.base.components.theather.ActorComponent;
import br.com.alexandrealessi.gdx.fox.base.components.theather.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.components.IDrawable;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.CarsGameConstants;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/04/15.
 */
public class VehicleFactory {

    public static final String CHASSIS = "chassis";
    public static final String REAR_WHEEL = "rear_wheel";
    public static final String FRONT_WHEEL = "front_wheel";

    private final RubeSceneWrapper rubeScene;
    private final ResourceManager resourceManager;

    public VehicleFactory(RubeSceneWrapper rubeSceneWrapper, ResourceManager resourceManager) {
        this.rubeScene = rubeSceneWrapper;
        this.resourceManager = resourceManager;
    }

    public CompositeActor createCar() {
        CompositeActor car = new CompositeActor();
        createChassi(car);
        createRearWheel(car);
        createFrontWheel(car);
        return car;

    }

    private void createFrontWheel(CompositeActor car) {
        final Body frontBody = rubeScene.getBody(FRONT_WHEEL);
//        addPart(car, new FrontWheel(frontBody), ImageDrawable.createFromTextureRegion(getRegion(rubeScene.getBindedImageFileName(frontBody))));
    }

    private void createRearWheel(CompositeActor car) {
        final Body rearBody = rubeScene.getBody(REAR_WHEEL);
//        addPart(car, new RearWheel(rearBody), ImageDrawable.createFromTextureRegion(getRegion(rubeScene.getBindedImageFileName(rearBody))));

    }

    private void createChassi(CompositeActor car) {
        final Body chassiBody = rubeScene.getBody(CHASSIS);
//        addPart(car, new Chassi(chassiBody), ImageDrawable.createFromTextureRegion(getRegion(rubeScene.getBindedImageFileName(chassiBody))));
    }

    public void addPart(CompositeActor ca, ActorComponent part) {
        addPart(ca, part, null);
    }

    public void addPart(CompositeActor ca, ActorComponent part, IDrawable drawable) {
        if (drawable != null) {
            part.setDrawable(drawable);
        }
        ca.addActor(part);
    }

    public TextureRegion getRegion(String name) {
        return resourceManager.getRegion(CarsGameConstants.Strings.GAME_ATLAS_NAME.value, name);
    }

}
