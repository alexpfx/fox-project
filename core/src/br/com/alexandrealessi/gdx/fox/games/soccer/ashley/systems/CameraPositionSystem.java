package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraPositionSystem extends EntitySystem {

    float lerp = 0.4f;
    private ImmutableArray<Entity> entities;

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, CameraFollowerComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            final CameraFollowerComponent cameraFollowerComponent =  ComponentMappers.CAMERA_FOLLOWER.get(entity);
            final Rectangle bounds = cameraFollowerComponent.getBounds();
            final PositionComponent positionComponent = ComponentMappers.POSITION.get(entity);
            final Camera camera = cameraFollowerComponent.getCamera();
            final Vector2 position = positionComponent.getPosition();
            camera.position.set(position.x * lerp, position.y * lerp, 1);

        }
    }
}
