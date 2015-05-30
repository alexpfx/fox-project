package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 25/05/15.
 */
public class Team {

    private String name;

    private Array<PlayerEntity> players = new Array<PlayerEntity>();

    public Team(String name, Array<PlayerEntity> players) {
        this.name = name;
        this.players = players;
    }

    public Array<PlayerEntity> getPlayers() {
        return players;
    }
}
