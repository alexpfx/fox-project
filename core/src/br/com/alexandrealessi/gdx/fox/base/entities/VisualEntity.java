package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alex on 01/05/2015.
 */
public interface VisualEntity extends Entity {
    void draw(SpriteBatch batch, float alpha);
    void setDrawable (Drawable drawable);
    void dispose ();
}
