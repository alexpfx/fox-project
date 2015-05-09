package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 06/05/15.
 */
public abstract class GameObject implements Entity {

    private Array<OnBodyMoveListener> bodyMoveListeners = new Array<OnBodyMoveListener>();
    private Array<OnDrawableMoveListener> drawableMoveListeners = new Array<OnDrawableMoveListener>();

    protected RigidBody body;
    private Drawable drawable;


    public void addMoveListener (OnBodyMoveListener listener){
        bodyMoveListeners.add(listener);
    }

    public void addMoveListener (OnDrawableMoveListener listener){
        drawableMoveListeners.add(listener);
    }


    public GameObject(RigidBody body) {
        this.body = body;
    }

    public GameObject(RigidBody body, Drawable drawable) {
        this(body);
        this.drawable = drawable;
        body.addOnMoveListener(drawable);
    }

    @Override
    public void update (float delta){
        updateBodyListeners();
        updateDrawableListeners ();
    }

    private void updateDrawableListeners() {
        if (drawable == null) return;
        for (OnDrawableMoveListener listener : drawableMoveListeners) {
            listener.drawableMovement(drawable.getPosition(), drawable.getDegAngle(), drawable.getWorldContext());
        }
    }

    private void updateBodyListeners() {
        if (body == null) return;
        body.update();
        for (OnBodyMoveListener bodyMoveListener : bodyMoveListeners) {
            bodyMoveListener.bodyMovement(body.getPosition(), body.getAngle(), body.getContext());
        }
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        if (drawable != null){
            drawable.draw(batch, alpha);
        }
    }

    public void dispose() {


    }
}
