package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 27/05/15.
 */
public class EntityUserData implements UserData {

    private boolean alive;
    private Entity playerEntity;

    private EntityUserData(Entity entity) {
        this.playerEntity = playerEntity;
        this.alive = true;
    }

    public static EntityUserData newInstance(Entity entity) {
        return new EntityUserData(entity);
    }

    @Override
    public boolean canDestroy() {
        return !alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
