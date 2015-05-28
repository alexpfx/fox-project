package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import br.com.alexandrealessi.gdx.fox.base.UserDataAction;
import com.badlogic.gdx.utils.Array;

import javax.swing.*;

/**
 * Created by alexandre on 27/05/15.
 */
public class PlayerUserData implements UserData{

    private boolean alive;
    private Player player;
    private Array<UserDataAction> actions = new Array<UserDataAction>();

    private PlayerUserData(Player player) {
        this.player = player;
        this.alive = true;
    }

    public static PlayerUserData getFor(Player player) {
        return new PlayerUserData(player);
    }

    @Override
    public boolean canDestroy() {
        return !alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Player getPlayer() {
        return player;
    }


}
