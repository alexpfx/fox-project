package br.com.alexandrealessi.gdx.fox.base.utils;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 09/05/15.
 */
public interface CameraPositioner  <T>{
    public void lookAt(T object);
    CameraPositioner<T> setCamera(CameraHolder camera);
    void update ();
}
