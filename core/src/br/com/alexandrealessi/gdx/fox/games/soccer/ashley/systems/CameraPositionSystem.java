package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraPositionSystem extends EntitySystem{

    private ImmutableArray<Entity> entities;
    private ComponentMapper<CameraFollowerComponent> cfm = ComponentMapper.getFor(CameraFollowerComponent.class);
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, CameraFollowerComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity:entities){
            final CameraFollowerComponent cameraFollowerComponent = cfm.get(entity);
            final PositionComponent positionComponent = pm.get(entity);
            cameraFollowerComponent.getCamera().position.set(positionComponent.getX(), positionComponent.getY(), 1);
        }
    }
}
