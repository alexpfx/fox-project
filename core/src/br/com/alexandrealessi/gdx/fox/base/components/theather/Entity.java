package br.com.alexandrealessi.gdx.fox.base.components.theather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 28/04/15.
 */
public interface Entity {
    void act (float delta);
    void draw (SpriteBatch bath, float alpha);
}
