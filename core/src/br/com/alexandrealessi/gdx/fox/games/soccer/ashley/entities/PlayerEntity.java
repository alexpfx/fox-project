package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 25/05/15.
 */
public class PlayerEntity extends Entity {
    private final String name;
    private final int number;
    private final Team team;

    private PlayerEntity(Builder builder) {
        name = builder.name;
        number = builder.number;
        team = builder.team;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static final class Builder {
        private String name;
        private int number;
        private Team team;
        private Array<Component> components;

        private Builder() {
            components = new Array<Component>();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Builder addComponent(Component component) {
            components.add(component);
            return this;
        }

        public PlayerEntity build() {
            final PlayerEntity playerEntity = new PlayerEntity(this);
            for (Component c : components) {
                playerEntity.add(c);
            }
            return playerEntity;
        }
    }
}
