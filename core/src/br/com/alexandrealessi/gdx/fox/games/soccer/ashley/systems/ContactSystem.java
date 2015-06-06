package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerBodyUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by alexandre on 27/05/15.
 */
public class ContactSystem extends EntitySystem implements ContactListener {


    private static final float secondsWaitingBeforeProcessContactBetweenPlayers = 1f;
    private Entity worldEntity;
    private float timecount = 0;

    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).get(0);
        final World world = ComponentMappers.WORLD.get(worldEntity).getWorld();
        world.setContactListener(this);
    }

    @Override
    public void beginContact(Contact contact) {
        processContact(contact);
        if (timecount > secondsWaitingBeforeProcessContactBetweenPlayers) {
            ballPlayerCollision(contact);
        }
    }

    private void processContact(Contact contact) {
        final Body bodyA = contact.getFixtureA().getBody();
        final Body bodyB = contact.getFixtureB().getBody();
        if (areBothPlayers(bodyA, bodyB)) {
            processContactBetweenPlayers(contact, bodyA, bodyB);

        }
        // others contacts processing.
    }

    private void processContactBetweenPlayers(Contact contact, Body playerBodyA, Body playerBodyB) {
        final float vx_a = Math.abs(playerBodyA.getLinearVelocity().x);
        final float vx_b = Math.abs(playerBodyB.getLinearVelocity().x);
        final float vy_a = Math.abs(playerBodyA.getLinearVelocity().y);
        final float vy_b = Math.abs(playerBodyB.getLinearVelocity().y);

        final float a_power = vx_a + vy_a;
        final float b_power = vx_b + vy_b;

        if (a_power > b_power) {
            if (!saved(playerBodyA)) {
                destroyIfNotSaved(playerBodyA);
            }
        } else {
            if (!saved(playerBodyB)) {
                destroyIfNotSaved(playerBodyB);
            }
        }
    }

    public void destroyIfNotSaved(Body playerBody) {
        if (!saved(playerBody)) {
            markForDestroy(playerBody);
        }
    }

    private boolean areBothPlayers(Body bodyA, Body bodyB) {
        return isPlayer(bodyA) && isPlayer(bodyB);
    }


    private void ballPlayerCollision(Contact contact) {



    }

    @Override
    public void update(float deltaTime) {
        timecount += deltaTime;
    }

    private boolean saved(Body b) {
        final boolean save = MathUtils.randomBoolean(.5f);
        if (save) b.applyLinearImpulse(MathUtils.random(-100, 100), MathUtils.random(-100, 100), b.getLocalCenter().x, b
                .getLocalCenter().y, true);
        return save;
    }

    private boolean isPlayer(Body body) {
        final Object userData = body.getUserData();
        return userData != null && userData instanceof PlayerBodyUserData;
    }

    private void markForDestroy(Body body) {
        final PlayerBodyUserData userData = (PlayerBodyUserData) body.getUserData();
        userData.setAlive(false);
    }


    public CollisionType determineCollisionType (Fixture fixtureA, Fixture fixtureB){


        return null;



    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    enum CollisionType {
        BALL_PLAYER, BALL_GOAL_LINE, PLAYER_PLAYER
    }



}
