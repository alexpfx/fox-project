package br.com.alexandrealessi.gdx.fox.games.soccer.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alexandre on 24/05/15.
 */
public class SpriteComponent extends Component {

    private Sprite sprite;

    public SpriteComponent (Sprite sprite){
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
