package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import com.badlogic.gdx.math.MathUtils;
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
    public void accelerate(float amount, float direction) {
        if (joint.isActive()) {
            joint.getBodyB().applyTorque(MathUtils.random(10f), true);
        }
    }

    @Override
    public void brek(float amount) {
        if (joint.isActive()){
            final WheelJoint wJoint = getWheelJoint();
            wJoint.enableMotor(false);
        }
    }

    private WheelJoint getWheelJoint() {
        return (WheelJoint) (WheelJoint) joint;
    }
}
