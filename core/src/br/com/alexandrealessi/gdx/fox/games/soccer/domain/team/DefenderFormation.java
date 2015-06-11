package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum DefenderFormation {
    DEFAULT_4(4, new PlayerPosition[]{LB, CB, CB, RB}),
    SWEAPER_5(5, new PlayerPosition[]{LB, CB, SW, CB, RB});

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
