package br.com.alexandrealessi.gdx.fox;

import br.com.alexandrealessi.gdx.fox.base.IDrawable;
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
    public void draw(Batch batch, float x, float y, float r, float scaleRatio) {
        spriteDrawable.draw(batch, x, y, 0, 0, spriteDrawable.getSprite().getWidth(), spriteDrawable.getSprite().getHeight(), 1, 1, r);
    }

    public static ImageDrawable createFromTextureRegion (TextureRegion textureRegion){
        return new ImageDrawable(new SpriteDrawable(new Sprite(textureRegion)));
    }

}
