package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 06/05/15.
 */
public class SpriteDrawable implements Drawable, RigidBody.OnMoveListener {

    private Sprite sprite;
    private WorldContext context;

    public SpriteDrawable(Sprite sprite, WorldContext context) {
        this.sprite = sprite;
        this.context = context;
    }

    @Override
    public void bodyMovement(Vector2 bodyPosition, float angle, WorldContext worldContext) {
        Vector2 spritePosition = calculatePosition(bodyPosition, worldContext);
        spritePosition.add(context.getWidth() / 2, context.getHeight() /2);
        spritePosition.sub(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(spritePosition.x, spritePosition.y);
        sprite.setRotation(MathUtils.radDeg * angle);
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        sprite.draw(batch, alpha);
    }

    @Override
    public Vector2 getPosition() {
        return Vector2.Zero.set(sprite.getX(), sprite.getY());
    }

    @Override
    public float getDegAngle() {
        return sprite.getRotation();
    }

    @Override
    public WorldContext getWorldContext() {
        return context;
    }

    //TODO: considerar jogar para uma classe utils se vier a ser usado em mais lugares.
    private Vector2 calculatePosition(Vector2 bodyPosition, WorldContext anotherContext) {
        final float ny = context.getHeight() / anotherContext.getHeight() * bodyPosition.y;
        final float nx = context.getWidth() / anotherContext.getWidth() * bodyPosition.x;
        return Vector2.Zero.set(nx, ny);
    }


    //    Vector2 to = WORLD.convert(SCREEN, position);
//    to.add(SCREEN.width() * 1 / 2f, SCREEN.height() * 1 / 2f);
//    to.sub(getWidth() / 2, getHeight() / 2);
//    return to;

}
