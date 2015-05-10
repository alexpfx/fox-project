package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 06/05/15.
 */
public abstract class GameObject implements Entity {


    protected RigidBody body;
    private Drawable drawable;

    private String objectName = "";


    public GameObject(RigidBody body) {
        this.body = body;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public GameObject(RigidBody body, Drawable drawable) {
        this(body);
        this.drawable = drawable;
        body.addOnMoveListener(drawable);
    }

    @Override
    public void update (float delta){
        body.update();
    }


    @Override
    public void draw(SpriteBatch batch, float alpha) {
        if (drawable != null){
            drawable.draw(batch, alpha);
        }
    }

    public void dispose() {

    }

    @Override
    public Vector2 getPosition() {
        return drawable != null?drawable.getPosition():Vector2.Zero;
    }

    @Override
    public Vector2 getPhysicalPosition() {
        return body.getPosition();
    }

    @Override
    public String toString() {
        return objectName;
    }

    @Override
    public Vector2 getDimensions() {
        return drawable != null? drawable.getDimensions(): Vector2.Zero;
    }
}
