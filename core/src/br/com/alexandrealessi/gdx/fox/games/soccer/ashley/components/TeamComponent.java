package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 07/06/15.
 */
public class TeamComponent extends Component {

    private Entity team;

    public TeamComponent(Entity team) {
        this.team = team;
    }

    public Entity getTeam() {
        return team;
    }
}
