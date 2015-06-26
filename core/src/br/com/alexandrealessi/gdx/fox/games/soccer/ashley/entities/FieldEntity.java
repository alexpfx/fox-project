package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Family;

/**
 * Created by alexandre on 26/06/15.
 */
public class FieldEntity extends UserEntity {

    protected FieldEntity(boolean buildable) {
        super(buildable);
    }

    @Override
    protected Component[] getComponents() {
        return new Component[0];
    }

    @Override
    protected Family getDistinctFamily() {
        return null;
    }
}
