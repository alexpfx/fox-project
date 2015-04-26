package br.com.alexandrealessi.gdx.fox.car.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 26/04/15.
 */
public interface IDrawable {

    void draw(Batch batch, float x, float y, float r, float scaleRatio);

}
