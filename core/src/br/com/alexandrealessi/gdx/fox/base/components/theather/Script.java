package br.com.alexandrealessi.gdx.fox.base.components.theather;

/**
 * Created by alexandre on 28/04/15.
 */
public interface Script {

    void init(Entity entity);

    void act(float delta);

    void dispose();

}
