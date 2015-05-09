package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 07/05/15.
 */
public class CameraHolder  {

    private Camera camera;
    private Entity entity;

    public CameraHolder(Camera camera, float width, float height, float zoom) {
        this.camera = camera;
        initCamera(camera, width, height, zoom);
    }

    private void initCamera(Camera camera, float width, float height, float zoom) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        ((OrthographicCamera) camera).zoom = zoom;
        camera.position.set(width / 2f, height / 2f, 0);
        camera.update();
    }

    public void lookFor(Entity e) {
        entity = e;

    }

    public void update() {
        if (entity != null){
            camera.position.set(entity.getPosition().x, entity.getPosition().y, 0);
        }
        camera.update();
    }

    public void setProjectionMatrix (SpriteBatch batch){
        batch.setProjectionMatrix(camera.combined);
    }

    public Camera getCamera() {
        return camera;
    }
}
