package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.base.UserDataAction;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/05/15.
 */
public class EntityUserData implements UserData {

    private boolean alive;
    private PlayerEntity playerEntity;

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
