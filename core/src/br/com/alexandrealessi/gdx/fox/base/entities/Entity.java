package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alex on 02/05/2015.
 */
public interface Entity {

    public void update (float delta);

    public void draw (SpriteBatch batch, float alpha);


}
