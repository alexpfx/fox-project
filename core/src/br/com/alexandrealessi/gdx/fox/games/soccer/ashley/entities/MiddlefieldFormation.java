package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import static br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition.*;
import static br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition.RB;

/**
 * Created by alexandre on 10/06/15.
 */
public enum  MiddlefieldFormation {

    DEFAULT(4, new PlayerPosition[]{CM, DM, CM});



    private PlayerPosition[] pos;
    private int number;

    MiddlefieldFormation(int number, PlayerPosition[] playerPositions) {
        this.number = number;
        this.pos = playerPositions;

    }
}
