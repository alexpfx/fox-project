package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

/**
 * Created by alexandre on 31/05/15.
 */
public enum TeamFormation {
    F442(4, 4, 2), F433(4, 3, 3);
    private int numberOfDefenders;
    private int numberOfMiddlefields;
    private int numberOfAttackers;

    TeamFormation(int numberOfDefenders, int numberOfMiddlefields, int numberOfAttackers) {
        this.numberOfDefenders = numberOfDefenders;
        this.numberOfMiddlefields = numberOfMiddlefields;
        this.numberOfAttackers = numberOfAttackers;
    }

    public int getNumberOfDefenders() {
        return numberOfDefenders;
    }

    public int getNumberOfMiddlefields() {
        return numberOfMiddlefields;
    }

    public int getNumberOfAttackers() {
        return numberOfAttackers;
    }
}

