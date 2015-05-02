package br.com.alexandrealessi.gdx.fox.base.components.theather;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by alexandre on 26/04/15.
 */
public class ActorComponent extends Actor {
    //TODO: considerar guardar o drawable no atributo userData do body.

    protected Body body;
    private Drawable drawable;

    public ActorComponent() {

    }

    protected ActorComponent(Body body) {
        setBody(body);
        setScale(1);
    }

    protected ActorComponent(Drawable drawable) {
        setDrawable(drawable);
    }

    protected ActorComponent(Body body, Drawable drawable) {
        this(body);
        setDrawable(drawable);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (drawable == null) {
            return;
        }
//        drawable.draw(batch, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getRotation(), getScaleX(), getScaleY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (body == null) {
            return;
        }
        doPhysicAct();
    }

    private void doPhysicAct() {
//        final float x = body.getPosition().x;
//        final float screenX = Sizes.WORLD.scaleX(x, Sizes.SCREEN) + Sizes.SCREEN.width() / 2 - getWidth() / 2;
//        final float y = body.getPosition().y;
//        final float screenY = Sizes.WORLD.scaleY(y, Sizes.SCREEN) + Sizes.SCREEN.height() / 2 - getHeight() / 2;
//        final float angle = body.getAngle();
//        float r = body.getAngle() * MathUtils.radDeg;
//        setPosition(screenX, screenY);
//        setOrigin(Align.center);
//        setRotation(r);
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        setWidth(drawable.getWidth());
        setHeight(drawable.getHeight());
    }

}
