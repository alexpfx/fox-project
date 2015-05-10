package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alex on 02/05/2015.
 */
public interface Entity {
    interface OnMoveListener{
        void onMove(Vector2 position, float angle, WorldContext context);
    }

    public void update (float delta);

    public void draw (SpriteBatch batch, float alpha);

    Vector2 getPosition ();

    Vector2 getPhysicalPosition ();

    Vector2 getDimensions ();



}
