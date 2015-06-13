package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain;

/**
 * Created by alexandre on 12/06/15.
 */
public enum TeamSide {

    LEFT (-1), RIGHT(1);

    private int multiplicator;

    TeamSide(int multiplicator) {
        this.multiplicator = multiplicator;
    }

    public int getMultiplicator() {
        return multiplicator;
    }
}
