package br.com.alexandrealessi.gdx.fox.base.actors;

import br.com.alexandrealessi.gdx.fox.car.SizeConstants;
import br.com.alexandrealessi.gdx.fox.car.actors.IDrawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

/**
 * Created by alexandre on 26/04/15.
 */
public abstract class ActorPart extends Actor {

    protected Body body;
    private IDrawable drawable;

    public ActorPart(Body body) {
        this.body = body;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (drawable == null) {
            return;
        }
        final float x = body.getPosition().x;
        final float y = body.getPosition().y;
        final float angle = body.getAngle();
        drawable.draw(batch, x, y, angle, 1f);
    }

    public void setDrawable(IDrawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void act(float delta) {
        float ratio = SizeConstants.WORLD.hratio(SizeConstants.SCREEN);
        float x = body.getPosition().x * ratio;
        float y = body.getPosition().y * ratio;
        float r = body.getAngle() * MathUtils.radDeg;

        setOrigin(Align.center);
        setPosition(x, y);
        setRotation(r);

    }
}
