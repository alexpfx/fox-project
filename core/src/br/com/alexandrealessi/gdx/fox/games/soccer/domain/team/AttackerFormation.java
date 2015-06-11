package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum AttackerFormation {

    DEFAULT_2(2, new PlayerPosition[]{WF, CF}),
    DEFAULT_3(3, new PlayerPosition[]{WF, CF, CF})
    ;

    private final int position;
    private final PlayerPosition[] playerPositions;

    AttackerFormation(int number, PlayerPosition[] playerPositions) {
        this.position = number;
        this.playerPositions = playerPositions;

    }
}
