package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 07/06/15.
 */
public interface EntityFactory <T extends Entity, E> {
    T create(E... e);
}
