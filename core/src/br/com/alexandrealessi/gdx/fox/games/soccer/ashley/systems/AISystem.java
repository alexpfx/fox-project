package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.SteerComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;

/**
 * Created by alexandre on 28/05/15.
 */
public class AISystem extends EntitySystem {

    ImmutableArray<Entity> entities;
    private ComponentMapper<SteerComponent> sm = ComponentMapper.getFor(SteerComponent.class);

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(SteerComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (Entity e : entities) {
            final SteerComponent steerComponent = sm.get(e);
            steerComponent.update(deltaTime);
        }
    }
}
