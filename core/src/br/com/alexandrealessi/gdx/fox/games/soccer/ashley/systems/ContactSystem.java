package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.box2d.SoccerContactListener;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
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
public class ContactSystem extends EntitySystem  {


    private static final float secondsWaitingBeforeProcessContactBetweenPlayers = 1f;
    private Entity worldEntity;
    private float timecount = 0;

    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).get(0);
        final World world = ComponentMappers.WORLD.get(worldEntity).getWorld();
        world.setContactListener(new SoccerContactListener());
    }


}
