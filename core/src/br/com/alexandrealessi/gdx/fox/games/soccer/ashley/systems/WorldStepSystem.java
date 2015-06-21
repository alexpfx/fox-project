package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.EntityUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by alexandre on 24/05/15.
 * Responsavel por incrementar a iteração do world e limpar se for necessario.
 */
public class WorldStepSystem extends EntitySystem {
    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 3;
    private static final int POSITION_ITERATIONS = 2;
    private Entity worldEntity;


    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).first();

    }

    @Override
    public void update(float deltaTime) {
        final WorldComponent worldComponent = ComponentMappers.WORLD.get(worldEntity);
        final World world = worldComponent.getWorld();
        final Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        clearWorld(world);
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    private void clearWorld(World world) {
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        final Iterator<Body> iterator = bodies.iterator();
        while (iterator.hasNext()) {
            final Body b = iterator.next();
            final UserData userData = (UserData) b.getUserData();
            if (userData != null && userData.canDestroy()) {
                world.destroyBody(b);
                iterator.remove();
            }
        }
    }

}
