package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 22/06/15.
 */
public abstract class UserEntity {

    private final Entity entity;
    private boolean wasBuilt = false;
    private Array<Class<? extends Component>> componentClasses;

    protected UserEntity() {
        this.entity = new Entity();
    }

    public final Entity getEntity() {
        if (!wasBuilt) {
            final Array<Component> components = getComponents();
            componentClasses = new Array<Class<? extends Component>>();
            for (Component c : components) {
                entity.add(c);
                componentClasses.add(c.getClass());
            }
            init(entity);
        }
        return entity;
    }

    protected abstract Array<Component> getComponents();

    public Class<? extends Component>[] getComponentClasses() {
        if (!wasBuilt) {
            throw new IllegalArgumentException("It needs to build entity before use it.");
        }
        return componentClasses.toArray();
    }

    /* Override when need to init some components */
    public void init(Entity entity) {

    }
}
