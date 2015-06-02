package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

/**
 * Created by alexandre on 25/05/15.
 */
public class Team {

    private String name;
    private boolean userTeam = false;

    public Team(String name, boolean userTeam) {
        this.name = name;
        this.userTeam = userTeam;
    }

    public boolean isUserTeam() {
        return userTeam;
    }

}
