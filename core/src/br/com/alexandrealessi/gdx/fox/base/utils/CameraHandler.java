package br.com.alexandrealessi.gdx.fox.base.utils;

import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 04/05/15.
 */
public class CameraHandler {


    private Camera camera;
    private Focable focable;


    public void follow(Focable focable){
        this.focable = focable;
        camera.position.set(focable.getX() / 2, focable.getY() / 2,0);
        camera.update();
    }


    public void render (){
        camera.update();
    }




}
