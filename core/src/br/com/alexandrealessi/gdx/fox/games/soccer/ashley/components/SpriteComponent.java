package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alexandre on 24/05/15.
 */
//TODO: mover para base.
public class SpriteComponent extends Component {

    private Sprite sprite;

    private SpriteComponent(Sprite sprite) {
        this.sprite = sprite;
    }

    public static SpriteComponent newInstance(Sprite sprite) {
        return new SpriteComponent(sprite);
    }

    public Sprite getSprite() {
        return sprite;
    }



}
