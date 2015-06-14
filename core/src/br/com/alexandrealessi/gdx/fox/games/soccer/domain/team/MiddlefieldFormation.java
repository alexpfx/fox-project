package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum MiddlefieldFormation implements FormationGroup {

    DEFAULT_3(3, new PlayerPosition[]{LDM, CM, RDM}),
    DEFAULT_4(4, new PlayerPosition[]{LDM, CDM, AM, RDM});

    private PlayerPosition[] positionArray;
    private int number;

    MiddlefieldFormation(int number, PlayerPosition[] playerPositions) {
        this.number = number;
        this.positionArray = playerPositions;

    }

    @Override
    public PlayerPosition[] getPositionArray() {
        return positionArray;
    }
}
