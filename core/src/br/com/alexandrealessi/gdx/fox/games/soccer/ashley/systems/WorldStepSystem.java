package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.base.box2d.MatchEventListener;
import br.com.alexandrealessi.gdx.fox.base.box2d.SoccerContactListener;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.MatchEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.*;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by alexandre on 24/05/15.
 */
public class WorldStepSystem extends EntitySystem implements MatchEventListener{
    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 3;
    private static final int POSITION_ITERATIONS = 2;
    private Entity worldEntity;


    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).first();
        final WorldComponent worldComponent = ComponentMappers.WORLD.get(worldEntity);
        final World world = worldComponent.getWorld();
        world.setContactListener(new SoccerContactListener(this));
    }

    @Override
    public void update(float deltaTime) {
        final WorldComponent worldComponent = ComponentMappers.WORLD.get(worldEntity);
        final World world = worldComponent.getWorld();
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

    @Override
    public void goal(Entity goalLineEntity) {
        final TeamComponent teamComponent = ComponentMappers.TEAM.get(goalLineEntity);
        

        System.out.println(goalLineEntity);

    }
}
