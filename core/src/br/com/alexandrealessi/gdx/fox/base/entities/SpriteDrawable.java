package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenContext;
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
    private ScreenContext context;

    public SpriteDrawable(Sprite sprite, ScreenContext context) {
        this.sprite = sprite;
        this.context = context;
    }

    @Override
    public void bodyMovement(Vector2 bodyPosition, float angle, WorldContext worldContext) {
        Vector2 spritePosition = calculatePosition(bodyPosition, worldContext);
        sprite.setPosition(spritePosition.x, spritePosition.y);
        sprite.setRotation(MathUtils.radDeg * angle);
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        sprite.draw(batch, alpha);
    }

    //TODO: considerar jogar para uma classe utils se vier a ser usado em mais lugares.
    private Vector2 calculatePosition(Vector2 bodyPosition, WorldContext worldContext) {
        final float ny = context.getHeight() / worldContext.getHeight() * bodyPosition.y;
        final float nx = context.getWidth() / worldContext.getWidth() * bodyPosition.x;
        return Vector2.Zero.add(nx, ny);
    }

}
