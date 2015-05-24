package br.com.alexandrealessi.gdx.fox.games.soccer.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.PositionComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class PhysicToScreenSystem extends EntitySystem {


    private ImmutableArray<Entity> entities;
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<BodyComponent> bm = ComponentMapper.getFor(BodyComponent.class);

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(BodyComponent.class, PositionComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (int i = 0 ; i < entities.size() ; i++){
            final Entity e = entities.get(i);
            final BodyComponent bodyComponent = bm.get(e);
            final PositionComponent positionComponent = pm.get(e);

        }
    }
}
