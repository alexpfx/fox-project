package br.com.alexandrealessi.gdx.fox;

import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import com.badlogic.ashley.core.Entity;

import java.lang.annotation.ElementType;

/**
 * Created by alexandre on 06/06/15.
 */
public class FixtureUserData {
    private FixtureType type;
    private Entity entity;

    public FixtureUserData(FixtureType type, Entity entity) {
        this.type = type;
        this.entity = entity;
    }

    public FixtureType getType() {
        return type;
    }

    public Entity getEntity() {
        return entity;
    }
}
