package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

/**
 * Created by alexandre on 22/06/15.
 */
public abstract class UserEntity {

    private final boolean buildable;
    private Entity entity;
    private boolean wasBuilt = false;

    protected UserEntity(boolean buildable) {
        this.buildable = buildable;
        if (buildable) {
            this.entity = new Entity();
        }
    }

    public final Entity getEntity() {
        if (!buildable) {
            throw new IllegalArgumentException("it's not a buildable Entity");
        }
        if (!wasBuilt) {
            final Component[] components = getComponents();
            for (Component c : components) {
                entity.add(c);
            }
            afterConstruct(entity);
        }
        return entity;
    }

    protected abstract Component[] getComponents();

    /* Override when need to init some components */
    public void afterConstruct(Entity entity) {

    }

    public ImmutableArray<Entity> getAllInEngine(Engine engine) {
        return engine.getEntitiesFor(getDistinctFamily());
    }

    protected abstract Family getDistinctFamily();

}
