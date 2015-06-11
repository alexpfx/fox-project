package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.Team;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 07/06/15.
 */
public class TeamComponent extends Component{

    private Team team;

    public TeamComponent(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
