package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 25/05/15.
 */
public class Team extends Entity {

    private String name;
    private PlayerEntity goalKeeper;
    private Array<PlayerEntity> defenders;
    private Array<PlayerEntity> middlefields;
    private Array<PlayerEntity> attackers;
    private Array <PlayerEntity> allPlayers;
    private boolean changed = false;


    private Team(Builder builder) {
        name = builder.name;
        goalKeeper = builder.goalKeeper;
        defenders = builder.defenders;
        middlefields = builder.middlefields;
        attackers = builder.attackers;
        allPlayers = Array.of(PlayerEntity.class);
        refreshAllPlayers();
    }

    private void refreshAllPlayers (){
        allPlayers.add(goalKeeper);
        allPlayers.addAll(defenders);
        allPlayers.addAll(middlefields);
        allPlayers.addAll(attackers);
    }

    public static Builder newBuilder(TeamFormation formation) {
        return new Builder(formation);
    }

    public String getName() {
        return name;
    }

    public PlayerEntity getGoalKeeper() {
        return goalKeeper;
    }

    public Array<PlayerEntity> getDefenders() {
        return defenders;
    }

    public Array<PlayerEntity> getMiddlefields() {
        return middlefields;
    }

    public Array<PlayerEntity> getAttackers() {
        return attackers;
    }

    public Array<PlayerEntity> getAllPlayers () {
        if (changed){
            refreshAllPlayers();
        }
        return allPlayers;
    }


    public static final class Builder {
        private String name;
        private PlayerEntity goalKeeper;
        private TeamFormation formation;
        private Array<PlayerEntity> defenders = new Array<PlayerEntity>();
        private Array<PlayerEntity> middlefields = new Array<PlayerEntity>();
        private Array<PlayerEntity> attackers = new Array<PlayerEntity>();

        private Builder(TeamFormation formation) {
            this.formation = formation;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder players(Array<PlayerEntity> players) {
            populatePlayersByFormation(players);
            return this;
        }

        private void populatePlayersByFormation(Array<PlayerEntity> players) {
            players.reverse();
            goalKeeper = pop(players, 1).first();
            defenders = pop(players, formation.getNumberOfDefenders());
            middlefields = pop(players, formation.getNumberOfMiddlefields());
            attackers = pop(players, formation.getNumberOfAttackers());
        }

        private Array<PlayerEntity> pop(Array<PlayerEntity> players, int amount) {
            Array<PlayerEntity> newArray = new Array<PlayerEntity>();
            for (int i = 0; i < amount; i++) {
                newArray.add(players.pop());
            }
            return newArray;
        }

        public Team build() {
            return new Team(this);
        }
    }
}
