package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public interface Drawable extends PhysicObject.OnMoveListener {

    void draw(SpriteBatch batch, float alpha);

    Vector2 getPosition ();
    float getDegAngle ();
    WorldContext getWorldContext ();
    Vector2 getDimensions ();

}
