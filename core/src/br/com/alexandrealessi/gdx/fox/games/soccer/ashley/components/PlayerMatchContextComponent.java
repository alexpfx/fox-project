package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 01/06/15.
 */
public class PlayerMatchContextComponent extends Component{

    private Team team;
    private PlayerPosition position;
    private boolean isSelected = false;

    public PlayerMatchContextComponent(Team team, PlayerPosition playerPosition) {
        this.team = team;
        this.position = playerPosition;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Team getTeam() {
        return team;
    }
}
