package br.com.alexandrealessi.gdx.fox.base.components;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by alexandre on 26/04/15.
 */
public class ImageDrawable implements IDrawable {

    private final SpriteDrawable spriteDrawable;

    public ImageDrawable(SpriteDrawable spriteDrawable) {
        this.spriteDrawable = spriteDrawable;
    }

    @Override
    public void draw(Batch batch, float x, float y, float originX, float originY, float width, float height, float r, float scaleX, float scaleY) {
        spriteDrawable.draw(batch, x, y, originX, originY, width, height, scaleX, scaleY, r);
    }

    @Override
    public float getWidth() {
        return spriteDrawable.getSprite().getWidth();
    }

    @Override
    public float getHeight() {
        return spriteDrawable.getSprite().getHeight();
    }

    public static ImageDrawable createFromTextureRegion(TextureRegion textureRegion) {
        return new ImageDrawable(new SpriteDrawable(new Sprite(textureRegion)));
    }

}
