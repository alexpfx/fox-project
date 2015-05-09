package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 06/05/15.
 */
public interface PhysicObject {
    void update();
    public void applyAngularImpulse(float impule, boolean wake);

    public static interface OnMoveListener {
        void bodyMovement(Vector2 position, float angle, WorldContext context);
    }

}
