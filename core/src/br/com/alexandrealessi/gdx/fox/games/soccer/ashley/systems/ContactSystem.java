package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.WorldComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by alexandre on 27/05/15.
 */
public class ContactSystem extends EntitySystem implements ContactListener {

    private Entity worldEntity;

    private static final float timeWaitBeforeProcessContactBetweenPlayers = 10f;
    private float timecount = 0;
    private ComponentMapper<WorldComponent> wm = ComponentMapper.getFor(WorldComponent.class);


    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).get(0);
        final World world = wm.get(worldEntity).getWorld();
        world.setContactListener(this);
    }

    @Override
    public void beginContact(Contact contact) {
        if (timecount > timeWaitBeforeProcessContactBetweenPlayers){
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
            markForDestroy(bodyB);
        } else {
            markForDestroy(bodyA);
        }
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
