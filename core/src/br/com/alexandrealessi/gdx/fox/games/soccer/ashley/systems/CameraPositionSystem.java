package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;

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

    float lerp = 0.4f;
    @Override
    public void update(float deltaTime) {
        for (Entity entity:entities){
            final CameraFollowerComponent cameraFollowerComponent = cfm.get(entity);
            final Rectangle bounds = cameraFollowerComponent.getBounds();
            final PositionComponent positionComponent = pm.get(entity);


            final Camera camera = cameraFollowerComponent.getCamera();
            camera.position.set(positionComponent.getX() * lerp, positionComponent.getY() * lerp, 1);


        }
    }
}
