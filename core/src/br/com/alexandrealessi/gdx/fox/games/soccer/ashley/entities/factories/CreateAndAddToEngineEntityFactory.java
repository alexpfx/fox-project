package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ArrayMap;

/**
 * Created by alexandre on 07/06/15.
 */
public abstract class CreateAndAddToEngineEntityFactory<E extends Entity> implements EntityFactory<E> {


    public final E createAndAddToEngine(CreateArguments arguments, Engine engine) {
        final E entity = create(arguments);
        engine.addEntity(entity);
        return entity;
    }


}
