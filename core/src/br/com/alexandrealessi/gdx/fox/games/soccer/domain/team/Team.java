package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 25/05/15.
 */
public class Team extends Entity{

    private String name;
    private boolean userTeam = false;
    private TeamFormation formation;

    public Team(String name, boolean userTeam, TeamFormation formation) {
        this.name = name;
        this.userTeam = userTeam;
        this.formation = formation;
    }

    public boolean isUserTeam() {
        return userTeam;
    }

    public TeamFormation getFormation() {
        return formation;
    }
}
