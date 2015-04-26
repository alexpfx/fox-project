package br.com.alexandrealessi.gdx.fox.car.actors;

import br.com.alexandrealessi.gdx.fox.base.actors.ActorPart;
import br.com.alexandrealessi.gdx.fox.base.actors.CompositeActor;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarManufacture {

    public static final String CHASSIS = "chassis";
    public static final String REAR_WHEEL = "rear_wheel";
    public static final String FRONT_WHEEL = "front_wheel";
    private final RubeSceneWrapper rubeScene;

    public CarManufacture(RubeSceneWrapper rubeSceneWrapper) {
        this.rubeScene = rubeSceneWrapper;
    }

    public CompositeActor createCar() {
        CompositeActor car = new CompositeActor();
        addPart(car, new Chassis(rubeScene.getBody(CHASSIS)));
        addPart(car, new RearWheel(rubeScene.getBody(REAR_WHEEL)));
        addPart(car, new FrontWheel(rubeScene.getBody(FRONT_WHEEL)));
        return car;
    }

    public void addPart(CompositeActor ca, ActorPart part) {
        ca.addActor(part);
    }

}
