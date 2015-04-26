package br.com.alexandrealessi.gdx.fox.car.actors;

import br.com.alexandrealessi.gdx.fox.base.actors.ActorPart;
import br.com.alexandrealessi.gdx.fox.base.actors.CompositeActor;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarManufacture {

    public static final String CHASSIS = "chassis";
    public static final String REAR_WHEEL = "rear_wheel";
    public static final String FRONT_WHEEL = "front_wheel";
    private final RubeScene rubeScene;

    public CarManufacture(RubeScene rubeScene) {
        this.rubeScene = rubeScene;
    }

    public CompositeActor createCar() {
        CompositeActor ca = new CompositeActor();
        ca.addActor(new Chassis(getBodyFromScene(CHASSIS)));
        ca.addActor(new FrontWheel(getBodyFromScene(FRONT_WHEEL)));
        ca.addActor(new RearWheel(getBodyFromScene(REAR_WHEEL)));
        return ca;
    }

    public void addPart (CompositeActor ca, ActorPart part){


    }


    private Body getBodyFromScene(String name) {
        return rubeScene.getNamed(Body.class, name).get(0);
    }

    private RubeImage getImageFromScene(String name) {
        return rubeScene.getNamed(RubeImage.class, name).get(0);
    }
}
