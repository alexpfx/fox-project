package br.com.alexandrealessi.gdx.fox.base.components.theather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 28/04/15.
 */
public interface Entity {
    void act(float delta);
    void draw(SpriteBatch bath, float alpha);
    Vector2 getWorldPosition();
}
