package br.com.alexandrealessi.gdx.fox.base.components;

import br.com.alexandrealessi.gdx.fox.games.CarsGameConstants;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

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
    public void draw(Batch batch, float alpha, Body body) {
        final float x = body.getPosition().x;
        final float y = body.getPosition().y;
        final float angle = body.getAngle();
        final Vector3 newPosition = calculatePosition(x, y, angle);
        spriteDrawable.draw(batch, newPosition.x, newPosition.y, getWidth() / 2, getHeight() / 2, getWidth(), getHeight(), 1, 1, newPosition.z);
    }

    private Vector3 calculatePosition(float x, float y, float angle) {
        final float xs = CarsGameConstants.Sizes.WORLD.scaleX(x, CarsGameConstants.Sizes.SCREEN) + CarsGameConstants.Sizes.SCREEN.width() / 2 - getWidth() / 2;
        final float ys = CarsGameConstants.Sizes.WORLD.scaleY(y, CarsGameConstants.Sizes.SCREEN) + CarsGameConstants.Sizes.SCREEN.height() / 2 - getHeight() / 2;
        final float rs = angle * MathUtils.radDeg;
        Vector3.Zero.set(0, 0, 0);
        return Vector3.Zero.add(xs, ys, rs);
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
