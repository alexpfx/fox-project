package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 31/05/15.
 */
public class CameraComponent extends Component {
    public CameraComponent(Camera camera) {
        this.camera = camera;
    }



    private Camera camera;

    public Camera getCamera() {
        return camera;
    }
}
