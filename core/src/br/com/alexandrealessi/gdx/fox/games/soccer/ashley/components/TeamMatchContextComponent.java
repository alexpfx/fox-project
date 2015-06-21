package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 12/06/15.
 */
public class TeamMatchContextComponent extends Component {

    private TeamSide teamSide;
    private boolean isUserTeam;

    private TeamMatchContextComponent(TeamSide teamSide, boolean isUserTeam) {
        this.teamSide = teamSide;
        this.isUserTeam = isUserTeam;
    }

    public static TeamMatchContextComponent newInstance(TeamSide teamSide, boolean isUserTeam) {
        return new TeamMatchContextComponent(teamSide, isUserTeam);
    }

    public TeamSide getTeamSide() {
        return teamSide;
    }

    public boolean isUserTeam() {
        return isUserTeam;
    }
}
