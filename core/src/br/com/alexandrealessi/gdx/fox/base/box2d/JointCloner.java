package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.FrictionJoint;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;

/**
 * Created by alexandre on 14/06/15.
 */
public class JointCloner {

    public Joint clone(Joint joint, Body bodyA, Body bodyB, World world) {
        final JointDef jointDef = createJointDef(joint, bodyA, bodyB);
        return world.createJoint(jointDef);
    }

    private JointDef createJointDef(Joint joint, Body bodyA, Body bodyB) {
        final JointDef.JointType type = joint.getType();
        JointDef def = createByType(type);
        setCommonProperties(joint, bodyA, bodyB, def);
        setPropertiesByJointType(type, joint, def);
        return def;
    }

    private JointDef createByType(JointDef.JointType type) {
        if (JointDef.JointType.FrictionJoint == type) {
            return new FrictionJointDef();
        }
        throw new IllegalArgumentException("tipo de joint não tratada ainda: " + type);
    }

    private void setPropertiesByJointType(JointDef.JointType type, Joint joint, JointDef def) {
        switch (type) {
            case FrictionJoint:
                setFrictionJointProperties((FrictionJoint) joint, (FrictionJointDef) def);
                break;
            default:
                throw new IllegalArgumentException("tipo de joint não tratada ainda: " + type);
        }
    }

    private void setFrictionJointProperties(FrictionJoint joint, FrictionJointDef def) {
        def.maxForce = joint.getMaxForce();
        def.maxTorque = joint.getMaxTorque();
        def.localAnchorA.set(0, 0);
        def.localAnchorB.set(0, 0);
    }

    private void setCommonProperties(Joint joint, Body bodyA, Body bodyB, JointDef def) {
        def.bodyA = bodyA;
        def.bodyB = bodyB;
        def.collideConnected = joint.getCollideConnected();
        def.type = joint.getType();
    }

}
