package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 07/05/15.
 */
public class CameraHolder implements Entity.OnDrawableMoveListener, Entity.OnBodyMoveListener{

    private Camera camera;
    private Entity entity;

    public CameraHolder(Camera camera) {
        this.camera = camera;
    }



    public void lookFor (Entity e){

    }

    @Override
    public void bodyMovement(Vector2 position, float angle, WorldContext context) {

    }

    @Override
    public void drawableMovement(Vector2 position, float angle, WorldContext context) {

    }
}
