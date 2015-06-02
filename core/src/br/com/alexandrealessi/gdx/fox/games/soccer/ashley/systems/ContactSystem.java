package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by alexandre on 27/05/15.
 */
public class ContactSystem extends EntitySystem implements ContactListener {

    private static final float timeWaitBeforeProcessContactBetweenPlayers = 10f;
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
        if (timecount > timeWaitBeforeProcessContactBetweenPlayers) {
            processContactBetweenPlayers(contact);
        }
    }

    @Override
    public void update(float deltaTime) {
        timecount += deltaTime;
    }

    private void processContactBetweenPlayers(Contact contact) {
        final Body bodyA = contact.getFixtureA().getBody();
        final Body bodyB = contact.getFixtureB().getBody();
        if (!isPlayer(bodyA) || !isPlayer(bodyB)) {
            return;
        }
        final float vx_a = Math.abs(bodyA.getLinearVelocity().x);
        final float vx_b = Math.abs(bodyB.getLinearVelocity().x);
        final float vy_a = Math.abs(bodyA.getLinearVelocity().y);
        final float vy_b = Math.abs(bodyB.getLinearVelocity().y);
        final float a_power = vx_a + vy_a;
        final float b_power = vx_b + vy_b;
        if ((a_power > b_power)) {
            if (save(bodyB)) return;
            markForDestroy(bodyB);
        } else {
            if (save(bodyA)) return;
            markForDestroy(bodyA);
        }
    }

    private boolean save(Body b) {
        final boolean save = MathUtils.randomBoolean(.5f);
        if (save) b.applyLinearImpulse(MathUtils.random(-100, 100), MathUtils.random(-100, 100), b.getLocalCenter().x, b
                .getLocalCenter().y, true);
        return save;
    }

    private boolean isPlayer(Body body) {
        final Object userData = body.getUserData();
        return userData != null && userData instanceof PlayerUserData;
    }

    private void markForDestroy(Body body) {
        final PlayerUserData userData = (PlayerUserData) body.getUserData();
        userData.setAlive(false);
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

}
