package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum DefenderFormation implements FormationGroup {
    DEFAULT_4(4, new PlayerPosition[]{LB, LCB, RCB, RB}),
    SWEAPER_5(5, new PlayerPosition[]{LB, LCB, SW, RCB, RB});

    private PlayerPosition[] positionArray;
    private int number;

    DefenderFormation(int number, PlayerPosition[] positionArray) {
        this.number = number;
        this.positionArray = positionArray;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public PlayerPosition[] getPositionArray() {
        return positionArray;
    }

}
