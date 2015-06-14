package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 13/06/15.
 */
public class OrganizedParameters {

    private final Vector2 initialPosition;
    private final PlayerPosition playerPosition;

    private OrganizedParameters(Vector2 initialPosition, PlayerPosition playerPosition) {
        this.initialPosition = initialPosition;
        this.playerPosition = playerPosition;
    }

    public Vector2 getInitialPosition() {
        return initialPosition;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public static OrganizedParameters newInstance(Vector2 initialPosition, PlayerPosition playerPosition) {
        return new OrganizedParameters(initialPosition, playerPosition);
    }
}
