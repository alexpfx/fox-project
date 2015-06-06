package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.base.BodyUserData;
import br.com.alexandrealessi.gdx.fox.base.UserDataAction;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/05/15.
 */
public class PlayerBodyUserData implements BodyUserData {

    private boolean alive;
    private PlayerEntity playerEntity;
    private Array<UserDataAction> actions = new Array<UserDataAction>();

    private PlayerBodyUserData(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
        this.alive = true;
    }

    public static PlayerBodyUserData getFor(PlayerEntity playerEntity) {
        return new PlayerBodyUserData(playerEntity);
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
