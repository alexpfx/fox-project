package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraPositioner;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.GameObject;

/**
 * Created by alexandre on 09/05/15.
 */
public class DrawableCameraPositioner implements CameraPositioner<Entity> {

    private CameraHolder camera;
    private Entity entity;

    @Override
    public void lookAt(Entity entity) {
        this.entity = entity;
    }

    @Override
    public CameraPositioner<Entity> setCamera(CameraHolder camera) {
        this.camera = camera;
        return this;
    }

    @Override
    public void update() {
        if (camera == null || entity == null)
            return;
        camera.setPosition(entity.getPosition().x + entity.getDimensions().x / 2, entity.getPosition().y + entity.getDimensions().y / 2);
    }
}
