package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import br.com.alexandrealessi.gdx.fox.games.soccer.input.Touch;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alexandre on 31/05/15.
 */
public class UnprojectInputSystem extends EntitySystem {

    Entity inputEntity;

    private Vector3 tmpVector = new Vector3();

    @Override
    public void addedToEngine(Engine engine) {
        inputEntity = engine
                .getEntitiesFor(Family.all(TouchDownInputComponent.class, CameraFollowerComponent.class).get()).get(0);
    }

    @Override
    public void update(float deltaTime) {
        final CameraComponent cameraComponent = ComponentMappers.CAMERA.get(inputEntity);
        final TouchDownInputComponent touchDownInputComponent = ComponentMappers.TOUCH_DOWN_INPUT.get(inputEntity);
        final Camera camera = cameraComponent.getCamera();
        if (!touchDownInputComponent.isConsumed()) {
            final Touch touch = touchDownInputComponent.getTouch();
            final Vector3 unproject = camera.unproject(tmpVector.set(touch.x, touch.y, 0));
            touchDownInputComponent.set(unproject);
        }
    }
}
