package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 12/06/15.
 */
public class TeamMatchContext extends Component {

    private TeamSide teamSide;

    private TeamMatchContext(TeamSide teamSide) {
        this.teamSide = teamSide;
    }

    public static TeamMatchContext newInstance(TeamSide teamSide) {
        return new TeamMatchContext(teamSide);
    }

    public TeamSide getTeamSide() {
        return teamSide;
    }


}
