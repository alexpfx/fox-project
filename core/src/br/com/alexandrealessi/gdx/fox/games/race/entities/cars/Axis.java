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
    public void accelerate(float amount, float target) {
        if (joint.isActive()) {
            final WheelJoint wJoint = getWheelJoint();
            wJoint.enableMotor(true);
            final float motorSpeed = Math.abs(wJoint.getMotorSpeed());
            final float jointSpeed = Math.abs(wJoint.getJointSpeed());
            System.out.println();
            System.out.println(motorSpeed);
            System.out.println(jointSpeed);

            if (jointSpeed < Math.abs(target)){
                wJoint.setMotorSpeed(target);
            }
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
