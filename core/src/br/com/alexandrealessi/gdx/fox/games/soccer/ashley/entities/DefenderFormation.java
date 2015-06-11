package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import static br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum DefenderFormation {
    DEFAULT(4, new PlayerPosition[]{LB, CB, CB, RB}),
    SWEAPER_1(5, new PlayerPosition[]{LB, CB, SW, CB, RB});

    private PlayerPosition[] pos;
    private int number;

    DefenderFormation(int number, PlayerPosition[] pos) {
        this.number = number;
        this.pos = pos;
    }

    public int getNumber() {
        return number;
    }

    public PlayerPosition[] getPos() {
        return pos;
    }
}
