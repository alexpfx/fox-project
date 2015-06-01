package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 31/05/15.
 */
public class MatchTeamsComponents extends Component{

    private Team playerTeam;
    private Team anotherTeam;

    public MatchTeamsComponents(Team playerTeam, Team anotherTeam){
        this.playerTeam = playerTeam;
        this.anotherTeam = anotherTeam;
    }

    public Team getAnotherTeam() {
        return anotherTeam;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }
}
