package br.com.alexandrealessi.gdx.fox.games.race.actors;

/**
 * Created by alexandre on 27/04/15.
 */
public class Peugeot extends Car {

    private static final String CHASSIS_BODY = "";
    private static final String CHASSIS_IMAGE = "";
    private static final String FRONT_BODY = "";
    private static final String FRONT_IMAGE = "";
    private static final String REAR_BODY = "";
    private static final String REAR_IMAGE = "";

    protected Peugeot() {
        super(new Chassis(CHASSIS_BODY, CHASSIS_IMAGE), new FrontWheel(FRONT_BODY, FRONT_IMAGE), new RearWheel(REAR_BODY, REAR_IMAGE));
    }
}
