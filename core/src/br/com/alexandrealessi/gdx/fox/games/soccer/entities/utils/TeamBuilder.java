package br.com.alexandrealessi.gdx.fox.games.soccer.entities.utils;

import br.com.alexandrealessi.gdx.fox.games.soccer.entities.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 25/05/15.
 */
public class TeamBuilder {
    public static final int NUMBER = 11;

    public Array<Player> createTeam(int defenders, int middlefields, int attackers) {
        final int playerCount = defenders + middlefields + attackers + 1;
        if (playerCount != NUMBER) {
            throw new IncorrectNumberOfPlayers("Expected / Actual " + NUMBER + "/" + playerCount);
        }
        Array<Player> players = new Array<Player>();
        players.add(new GoalKeeper("gk"));
        for (int i = 0; i < defenders; i++) {
            players.add(new Defender("df" + i++));
        }
        for (int i = 0; i < middlefields; i++) {
            players.add(new MiddleField("md" + i++));
        }
        for (int i = 0; i < attackers; i++) {
            players.add(new Attacker("at"));
        }
        return players;
    }

}
