package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraFollowerComponent extends Component {

    private Camera camera;

    public CameraFollowerComponent(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

}
