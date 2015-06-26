package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 01/06/15.
 */
public class PlayerMatchContextComponent extends Component {

    private Entity team;
    private PlayerPosition position;
    private int playerNumber;
    private Vector2 initialPosition;

    private boolean isSelected = false;

    private PlayerMatchContextComponent(Entity team, PlayerPosition playerPosition, int playerNumber, Vector2 initialPosition) {
        this.team = team;
        this.position = playerPosition;
        this.playerNumber = playerNumber;
        this.initialPosition = initialPosition;
    }

    public static PlayerMatchContextComponent newInstance(Entity team, PlayerPosition playerPosition, int playerNumber, Vector2 initialPosition) {
        return new PlayerMatchContextComponent(team, playerPosition, playerNumber, initialPosition);
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

    public Entity getTeam() {
        return team;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Vector2 getInitialPosition() {
        return initialPosition;
    }
}
