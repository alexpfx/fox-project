package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

/**
 * Created by alexandre on 07/06/15.
 */
public abstract class CreateAndAddToEngineEntityFactory<T extends Entity> implements EntityFactory <T> {

    @Override
    public Entity createAndAddToEngine(Engine engine) {
        final T entity = create();
        engine.addEntity(entity);
        return entity;
    }


}
