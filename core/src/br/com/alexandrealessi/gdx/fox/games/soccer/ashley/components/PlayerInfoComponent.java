package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 09/06/15.
 */
public class PlayerInfoComponent extends Component {
    private String nome;

    private PlayerInfoComponent(String nome) {
        this.nome = nome;
    }

    public static PlayerInfoComponent newInstance(String nome) {
        return new PlayerInfoComponent(nome);
    }

    public String getNome() {
        return nome;
    }
}
