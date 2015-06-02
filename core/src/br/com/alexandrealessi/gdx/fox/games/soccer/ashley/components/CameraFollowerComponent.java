package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraFollowerComponent extends Component {

    private final Camera camera;
    private final Rectangle bounds;

    public CameraFollowerComponent(Camera camera, Rectangle bounds) {
        this.camera = camera;

        this.bounds = bounds;
    }

    public Camera getCamera() {
        return camera;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
