package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Player;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.WorldComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Iterator;

/**
 * Created by alexandre on 24/05/15.
 */
public class WorldStepSystem extends EntitySystem {
    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 3;
    private static final int POSITION_ITERATIONS = 2;
    private Entity worldEntity;
    private ComponentMapper<WorldComponent> wm = ComponentMapper.getFor(WorldComponent.class);

    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).first();
    }

    @Override
    public void update(float deltaTime) {
        final WorldComponent worldComponent = wm.get(worldEntity);
        final World world = worldComponent.getWorld();
        clearWorld (world);
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    private void clearWorld(World world) {
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        final Iterator<Body> iterator = bodies.iterator();
        while (iterator.hasNext()){
            final Body b = iterator.next();
            final UserData userData = (UserData) b.getUserData();
            if (userData != null && userData.canDestroy()){
                world.destroyBody(b);
                iterator.remove();
            }
        }
    }
}