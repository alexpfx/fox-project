package br.com.alexandrealessi.gdx.fox.base.entities;

/**
 * Created by alex on 01/05/2015.
 */
public interface Physical {
    void init (BodyWrapper bodyWrapper);
    void update (float delta);
    void dispose ();

    BodyWrapper getBody ();
}
