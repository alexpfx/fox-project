package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alex on 01/05/2015.
 */
public class Stage {

    private Array<Entity> entities;

    public Stage() {
        entities = new Array<Entity>();
    }

    public void render() {
        for (Entity entity : entities) {
            entity.render();
        }
    }


    public Array<Entity> getEntities() {
        return entities;
    }
}
