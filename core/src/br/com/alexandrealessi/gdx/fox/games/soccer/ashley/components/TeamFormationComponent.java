package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.TeamFormation;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 12/06/15.
 */
public class TeamFormationComponent extends Component {
    private TeamFormation formation;

    private TeamFormationComponent(TeamFormation formation) {
        this.formation = formation;
    }

    public static TeamFormationComponent newInstance(TeamFormation formation) {
        return new TeamFormationComponent(formation);
    }

    public TeamFormation getFormation() {
        return formation;
    }
}
