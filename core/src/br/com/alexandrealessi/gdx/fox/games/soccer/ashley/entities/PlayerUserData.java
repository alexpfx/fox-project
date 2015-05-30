package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.base.UserDataAction;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/05/15.
 */
public class PlayerUserData implements UserData{

    private boolean alive;
    private PlayerEntity playerEntity;
    private Array<UserDataAction> actions = new Array<UserDataAction>();

    private PlayerUserData(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
        this.alive = true;
    }

    public static PlayerUserData getFor(PlayerEntity playerEntity) {
        return new PlayerUserData(playerEntity);
    }

    @Override
    public boolean canDestroy() {
        return !alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }


}
