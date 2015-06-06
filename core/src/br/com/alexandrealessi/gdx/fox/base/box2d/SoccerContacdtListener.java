package br.com.alexandrealessi.gdx.fox.base.box2d;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerEntity;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by alex on 06/06/2015.
 */
public abstract class SoccerContacdtListener implements ContactListener {

    protected abstract void contactBallPlayer(UserData ball, UserData player);

    protected abstract void contactBallPost(UserData ball, UserData post);

    protected abstract void contactPlayerPlayer(UserData playerA, UserData playerB);


    @Override
    final public void beginContact(Contact contact) {
        resolveContact(contact);
    }

    private void resolveContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        UserData uDataA = getFixtureUserData(fixtureA);
        UserData uDataB = getFixtureUserData(fixtureB);

        if (areBothPlayers(fixtureA, fixtureB)) {
            contactPlayerPlayer(uDataA, uDataB);
        } else if (isBallAndPlayer(fixtureA, fixtureB)) {
            contactBallPlayer(uDataA, uDataB);
        } else if (isBallAndPost(fixtureA, fixtureB)) {
            contactBallPost(uDataA, uDataB);
        }
    }

    private UserData getFixtureUserData(Fixture fixture) {
        return (UserData) fixture.getUserData();
    }

    private boolean isBallAndPlayer(Fixture fixtureA, Fixture fixtureB) {
        return isBall(fixtureA) && isPlayer(fixtureA) || isBall(fixtureB) && isPlayer(fixtureA);
    }

    private boolean isBallAndPost(Fixture fixtureA, Fixture fixtureB) {
        return isBall(fixtureA) && isGoalLine(fixtureB) || isBall(fixtureB) && isGoalLine(fixtureA);
    }

    private boolean areBothPlayers(Fixture fixtureA, Fixture fixtureB) {
        return (isPlayer(fixtureA) && isPlayer(fixtureB));
    }


    public boolean isPlayer(Fixture fixture) {
        return (FixtureType.PLAYER == ((FixtureUserData) fixture.getUserData()).getType());
    }

    public boolean isGoalLine(Fixture fixture) {
        return (FixtureType.GOAL_LINE_HOME == ((FixtureUserData) fixture.getUserData()).getType()) ||
                (FixtureType.GOAL_LINE_VISITOR == ((FixtureUserData) fixture.getUserData()).getType());
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
