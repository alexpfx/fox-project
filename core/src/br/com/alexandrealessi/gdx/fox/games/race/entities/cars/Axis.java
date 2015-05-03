package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;

/**
 * Created by alexandre on 03/05/15.
 */
public class Axis implements Accelerable {

    private Joint joint;

    public Axis(Joint joint) {
        this.joint = joint;
    }

    @Override
    public void accelerate(float amount) {
        if (joint.isActive()) {
            final WheelJoint wJoint = (WheelJoint) (WheelJoint) joint;
            wJoint.enableMotor(true);
            wJoint.setMotorSpeed(wJoint.getMotorSpeed() + amount);
        }

    }
}
