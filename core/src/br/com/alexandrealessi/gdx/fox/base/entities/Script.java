package br.com.alexandrealessi.gdx.fox.base.entities;

/**
 * Created by alex on 01/05/2015.
 */
public interface Script {

    void init(Physical physical);

    void run(float delta);

    void dispose();

}
