package br.com.alexandrealessi.gdx.fox.base.box2d;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by alex on 06/06/2015.
 */
public abstract class SoccerResolverContactListener implements ContactListener {

    protected abstract void contactBallPlayer(FixtureUserData ball, FixtureUserData player);

    protected abstract void contactBallGoalLine(FixtureUserData ball, FixtureUserData goalLine);

    protected abstract void contactPlayerPlayer(FixtureUserData playerA, FixtureUserData playerB);

    @Override
    final public void beginContact(Contact contact) {
        resolveContact(contact);
    }

    private void resolveContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        FixtureUserData uDataA = getFixtureUserData(fixtureA);
        FixtureUserData uDataB = getFixtureUserData(fixtureB);
        if (uDataA == null || uDataB == null) {
            return;
        }

        if (areBothPlayers(fixtureA, fixtureB)) {
            contactPlayerPlayer(uDataA, uDataB);
        } else if (isBallAndPlayer(fixtureA, fixtureB)) {
            if (isBall(fixtureA)) {
                contactBallPlayer(uDataA, uDataB);
            } else {
                contactBallPlayer(uDataB, uDataA);
            }
        } else if (isBallAndGoalLine(fixtureA, fixtureB)) {
            if (isGoalLine(fixtureA)) {
                contactBallGoalLine(uDataB, uDataA);
            } else {
                contactBallGoalLine(uDataA, uDataB);
            }
        }
    }

    private FixtureUserData getFixtureUserData(Fixture fixture) {
        return (FixtureUserData) fixture.getUserData();
    }

    private boolean isBallAndPlayer(Fixture fixtureA, Fixture fixtureB) {
        return isBall(fixtureA) && isPlayer(fixtureA) || isBall(fixtureB) && isPlayer(fixtureA);
    }

    private boolean isBallAndGoalLine(Fixture fixtureA, Fixture fixtureB) {
        return isBall(fixtureA) && isGoalLine(fixtureB) || isBall(fixtureB) && isGoalLine(fixtureA);
    }

    private boolean areBothPlayers(Fixture fixtureA, Fixture fixtureB) {
        return (isPlayer(fixtureA) && isPlayer(fixtureB));
    }

    public boolean isPlayer(Fixture fixture) {
        return (FixtureType.PLAYER == ((FixtureUserData) fixture.getUserData()).getType());
    }

    public boolean isGoalLine(Fixture fixture) {
        return (FixtureType.GOAL_LINE == ((FixtureUserData) fixture.getUserData()).getType());
    }

    public boolean isBall(Fixture fixture) {
        return (FixtureType.BALL == ((FixtureUserData) fixture.getUserData()).getType());
    }

    @Override
    final public void endContact(Contact contact) {

    }

    @Override
    final public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    final public void postSolve(Contact contact, ContactImpulse impulse) {

    }

}
