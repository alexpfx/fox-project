package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import static br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition.*;

/**
 * Created by alexandre on 10/06/15.
 */
public enum AttackerFormation implements FormationGroup{

    DEFAULT_2(2, new PlayerPosition[]{RST, LST}),
    DEFAULT_3(3, new PlayerPosition[]{RST, CF, LST})
    ;

    private final int position;
    private final PlayerPosition[] positionArray;

    AttackerFormation(int number, PlayerPosition[] positionArray) {
        this.position = number;
        this.positionArray = positionArray;

    }

    @Override
    public PlayerPosition[] getPositionArray() {
        return positionArray;
    }
}
