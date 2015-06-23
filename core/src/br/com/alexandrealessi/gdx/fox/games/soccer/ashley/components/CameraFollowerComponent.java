package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraFollowerComponent extends Component {

    private final Camera camera;

    private CameraFollowerComponent(Camera camera) {
        this.camera = camera;
    }

    public static CameraFollowerComponent newInstance(Camera camera) {
        return new CameraFollowerComponent(camera);
    }

    public Camera getCamera() {
        return camera;
    }

}
