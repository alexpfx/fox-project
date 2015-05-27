package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 25/05/15.
 */
public class Player extends Entity {
    private String name;
    private int number;
    private PlayerPosition position;
    private Team team;
    private int contacts = 0;

    public Player(String name, int number, PlayerPosition position) {
        this.team = team;
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void add() {
        contacts++;
    }
    public void sub (){
        contacts--;
    }


    public int getContacts() {
        return contacts;
    }

    public boolean reached(int amount) {
        return contacts == amount;
    }

}
