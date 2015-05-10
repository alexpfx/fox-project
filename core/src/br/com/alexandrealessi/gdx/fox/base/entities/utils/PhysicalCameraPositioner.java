package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraPositioner;

/**
 * Created by alexandre on 09/05/15.
 */
public class PhysicalCameraPositioner implements CameraPositioner <Entity> {

    private CameraHolder camera;
    private Entity entity;

    @Override
    public void lookAt(Entity entity) {
        this.entity = entity;
    }


    public void update (){
        if (camera == null || entity == null)
            return;
        camera.setPosition(entity.getPhysicalPosition().x , entity.getPhysicalPosition().y );
        camera.update();

    }


    @Override
    public CameraPositioner<Entity> setCamera(CameraHolder camera) {
        this.camera = camera;
        return this;
    }
}
