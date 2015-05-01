package br.com.alexandrealessi.gdx.fox.base.components;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.Random;

import static br.com.alexandrealessi.gdx.fox.games.CarsGameConstants.ResolutionConstants.*;

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

    private static Random rand = new Random();


    @Override
    public void draw(Batch batch, float alpha, Body body) {
        final float x = body.getPosition().x;
        final float y = body.getPosition().y;
        final float angle = body.getAngle();
        final Vector3 newPosition = calculatePosition(body.getPosition(), angle);
        spriteDrawable.draw(batch, newPosition.x, newPosition.y, getWidth() / 2, getHeight() / 2, getWidth(), getHeight(), 1, 1, newPosition.z);
    }

    private Vector3 calculatePosition(Vector2 position, float angle) {

        final Vector2 to = Transform.value(position).from(WORLD).to(SCREEN);
//        final Vector2 to = new Transform().nvalue(position).from(WORLD).to(SCREEN);
//        new CarsGameConstants.Sizes.Transform().nvalue(position);

//        final Vector2 to = TRANSFORM.value(position).from(WORLD).to(SCREEN);
        to.mulAdd(SCREEN.value, 1 / 2f).sub(getWidth() / 2, getHeight() / 2);
        float xs = to.x;
        float ys = to.y;
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
