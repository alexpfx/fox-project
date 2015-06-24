package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by alexandre on 09/06/15.
 */
public class ScaledSprite {
    private Sprite sprite;

    private ScaledSprite(Sprite sprite, float scale) {
        this.sprite = sprite;
        sprite.setScale(scale);
    }

    public static ScaledSprite create(Sprite sprite, float scale) {
        return new ScaledSprite(sprite, scale);
    }
    public static ScaledSprite createUsingHeight(Sprite sprite, float scaleFactor){
        return new ScaledSprite(sprite, scaleFactor / sprite.getHeight());
    }

    public Sprite getSprite() {
        return sprite;
    }
}
