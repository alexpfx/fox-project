package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.ASPECT_RATIO;
import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.SCREEN;
import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.WORLD;

/**
 * Created by alexandre on 26/04/15.
 */
public class ImageDrawable implements Drawable {

    private final SpriteDrawable spriteDrawable;

    private ImageDrawable(SpriteDrawable spriteDrawable) {
        this.spriteDrawable = spriteDrawable;
    }

    public static ImageDrawable createFromTextureRegion(TextureRegion textureRegion) {
        final ImageDrawable imageDrawable = new ImageDrawable(new SpriteDrawable(new Sprite(textureRegion)));
        return imageDrawable;

    }

    @Override
    public void draw(SpriteBatch  batch, float alpha, Vector2 position, float degAngle) {
        final Vector2 newPosition = calculatePosition(position);
        spriteDrawable.draw(batch, newPosition.x, newPosition.y, getWidth() / 2, getHeight() / 2, getWidth(), getHeight(), 1, 1, degAngle);
    }

    private Vector2 calculatePosition(Vector2 position) {
        Vector2 to = WORLD.convert(SCREEN, position);
        to.add(SCREEN.scale(ASPECT_RATIO.value()) * 1 / 2f, SCREEN.value() * 1 / 2f);
        to.sub(getWidth() / 2, getHeight() / 2);
        return to;
//        return position;
    }


    @Override
    public float getWidth() {
        return spriteDrawable.getSprite().getWidth();
    }

    @Override
    public float getHeight() {
        return spriteDrawable.getSprite().getHeight();
    }

}
