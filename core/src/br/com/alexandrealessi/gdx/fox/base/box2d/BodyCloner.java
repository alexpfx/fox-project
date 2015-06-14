package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 09/06/15.
 */
public class BodyCloner {

    private BodyCloner() {
    }

    public static BodyCloner newInstance() {
        return new BodyCloner();
    }

    public Body clone (Body body){
        final Array<Fixture> fixtureList = body.getFixtureList();
        final Array<JointEdge> jointList = body.getJointList();
        final World world = body.getWorld();
        final BodyDef bodyDef = createBodyDef(body);
        final Body cloneBody = world.createBody(bodyDef);
        cloneFixtures(fixtureList, cloneBody);
        cloneJoints (jointList, cloneBody);
        final Object userData = body.getUserData();
        cloneBody.setUserData(userData);
        return cloneBody;
    }

    private void cloneJoints(Array<JointEdge> jointList, Body cloneBody) {
        JointCloner jointCloner = new JointCloner();
        for (JointEdge j:jointList){
            jointCloner.clone(j.joint, j.other, cloneBody, cloneBody.getWorld());
        }
    }

    private BodyDef createBodyDef (Body body){
        BodyDef def = new BodyDef();
        def.type = body.getType();
        def.position.set(body.getPosition().x, body.getPosition().y);
        def.active = body.isActive();
        def.allowSleep = body.isSleepingAllowed();
        def.angle = body.getAngle();
        def.angularDamping = body.getAngularDamping();
        def.angularVelocity = body.getAngularVelocity();
        def.awake = body.isAwake();
        def.bullet = body.isBullet();
        def.fixedRotation = body.isFixedRotation();
        def.gravityScale = body.getGravityScale();
        def.allowSleep = body.isSleepingAllowed();
        return def;
    }

    private void cloneFixtures(Array<Fixture> fixtureList, Body clone) {
        FixtureCloner fixtureCloner = FixtureCloner.newInstance();
        for (Fixture f: fixtureList){
            final FixtureUserDataComposite fixtureClone = fixtureCloner.clone(f);
            final Object fixtureUserData = f.getUserData();
            final FixtureDef fixtureDef = fixtureClone.getFixtureDef();
            final Fixture fixture = clone.createFixture(fixtureDef);
            fixture.setUserData(fixtureUserData);
        }
    }

}
