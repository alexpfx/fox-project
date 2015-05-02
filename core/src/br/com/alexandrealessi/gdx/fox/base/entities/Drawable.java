package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public interface Drawable {

    void draw(SpriteBatch batch, float alpha, Vector2 position, float degAngle);

    public float getWidth();

    public float getHeight();



}
