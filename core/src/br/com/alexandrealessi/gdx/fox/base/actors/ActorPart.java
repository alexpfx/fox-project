package br.com.alexandrealessi.gdx.fox.base.actors;

import br.com.alexandrealessi.gdx.fox.base.IDrawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import static br.com.alexandrealessi.gdx.fox.car.CarGameConstants.Sizes;

/**
 * Created by alexandre on 26/04/15.
 */
public abstract class ActorPart extends Actor {

    protected Body body;
    private IDrawable drawable;

    public ActorPart(Body body) {
        this.body = body;
//        setScale(Sizes.SCREEN.xTo(1, Sizes.WORLD), Sizes.SCREEN.yTo(1, Sizes.WORLD));
        setScale(1);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (drawable == null) {
            return;
        }
        drawable.draw(batch, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getRotation(), getScaleX(), getScaleY());
    }

    public void setDrawable(IDrawable drawable) {
        this.drawable = drawable;
        setWidth(drawable.getWidth());
        setHeight(drawable.getHeight());

    }

    @Override
    public void act(float delta) {
        final float x = body.getPosition().x;
        final float screenX = Sizes.WORLD.xTo(x, Sizes.SCREEN) + Sizes.SCREEN.width()/ 2 - getWidth() / 2;

        final float y = body.getPosition().y;
        final float screenY = Sizes.WORLD.yTo(y, Sizes.SCREEN) + Sizes.SCREEN.height() / 2 - getHeight() / 2;

        final float angle = body.getAngle();
        float r = body.getAngle() * MathUtils.radDeg;

        setPosition(screenX, screenY);
        setOrigin(Align.center);
        setRotation(r);
    }


}
