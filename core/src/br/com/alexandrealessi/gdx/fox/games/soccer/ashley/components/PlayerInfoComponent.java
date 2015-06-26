package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 09/06/15.
 */
public class PlayerInfoComponent extends Component {
    private String nome;
    private int ballPlayerContact = 0;

    private PlayerInfoComponent(String nome) {
        this.nome = nome;
    }

    public static PlayerInfoComponent newInstance(String nome) {
        return new PlayerInfoComponent(nome);
    }

    public String getNome() {
        return nome;
    }

    public void incrementBallPlayer() {
        ballPlayerContact++;
        System.out.println(ballPlayerContact);
    }

    public boolean wasReach() {
        incrementBallPlayer();
        return ballPlayerContact >= 6;
    }

}
