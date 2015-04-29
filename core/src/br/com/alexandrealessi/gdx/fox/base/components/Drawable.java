package br.com.alexandrealessi.gdx.fox.base.components;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/04/15.
 */
public interface Drawable {

    /*
      Drawable deve saber desenhar a si mesmo usando as informacoes do body, se quiser.
     */
    void draw(Batch batch, float alpha, Body body);

    public float getWidth();

    public float getHeight();

}
