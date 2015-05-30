package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Camera;

/**
 * Created by alexandre on 30/05/15.
 */
public class CameraFollowerComponent extends Component {

    private Camera camera;
    private PositionComponent positionComponent;

    public CameraFollowerComponent(Camera camera, PositionComponent positionComponent) {
        this.camera = camera;
        this.positionComponent = positionComponent;
    }

    public Camera getCamera() {
        return camera;
    }

    public PositionComponent getPositionComponent() {
        return positionComponent;
    }
}
