package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

/**
 * Created by alexandre on 10/06/15.
 */
public enum AttackerFormation {

    DEFAULT(2, new PlayerPosition[]{});

    private final int position;
    private final PlayerPosition[] playerPositions;

    AttackerFormation(int number, PlayerPosition[] playerPositions) {
        this.position = number;
        this.playerPositions = playerPositions;

    }
}
