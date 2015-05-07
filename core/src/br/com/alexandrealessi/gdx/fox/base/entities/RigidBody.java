package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 06/05/15.
 */
public class RigidBody implements PhysicObject {

    private Array<OnMoveListener> moveListeners = new Array<OnMoveListener>();
    private Body body;
    private WorldContext context;

    public static interface OnMoveListener {
        void bodyMovement(Vector2 position, float angle, WorldContext context);
    }

    public RigidBody(Body body, WorldContext context) {
        this.body = body;
        this.context = context;
    }


    /**
     * Atualiza a posicao dos listeners quanto a posicao deste RigidBody.
     */
    @Override
    public void update() {
        for (OnMoveListener listener : moveListeners) {
            listener.bodyMovement(body.getPosition(), body.getAngle(), context);
        }
    }

    public void addOnMoveListener(OnMoveListener listener) {
        if (!moveListeners.contains(listener, true)){
            moveListeners.add(listener);
        }
    }

    public void applyAngularImpulse(float impule, boolean wake){
        body.applyAngularImpulse(impule, wake);
    }
}
