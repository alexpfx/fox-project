package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.ScaledSprite;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 12/06/15.
 */
public class TeamInfoComponent extends Component {
    private String name;

    private ScaledSprite mainUniform;

    private ScaledSprite secondaryUniform;
    private ScaledSprite gkUniform;

    private TeamInfoComponent(String name, ScaledSprite mainUniform, ScaledSprite gkUniform) {
        this.name = name;
        this.mainUniform = mainUniform;
        this.gkUniform = gkUniform;
    }

    public static TeamInfoComponent newInstance(String name, ScaledSprite mainUniform, ScaledSprite gkUniform) {
        return new TeamInfoComponent(name, mainUniform, gkUniform);
    }
}
