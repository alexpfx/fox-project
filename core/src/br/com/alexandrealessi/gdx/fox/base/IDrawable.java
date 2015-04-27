package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 26/04/15.
 */
public interface IDrawable {


    void draw(Batch batch, float x, float y, float originX, float originY, float width, float height, float r, float scaleX, float scaleY);
    float getWidth ();
    float getHeight ();

}
