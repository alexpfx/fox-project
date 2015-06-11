package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum  MiddlefieldFormation {

    DEFAULT_3(3, new PlayerPosition[]{CM, DM, CM}),
    DEFAULT_4(4, new PlayerPosition[]{CM, DM, AM, CM})

    ;




    private PlayerPosition[] pos;
    private int number;

    MiddlefieldFormation(int number, PlayerPosition[] playerPositions) {
        this.number = number;
        this.pos = playerPositions;

    }
}
