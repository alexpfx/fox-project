package br.com.alexandrealessi.gdx.fox.base.actors;

import br.com.alexandrealessi.gdx.fox.car.actors.IDrawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

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
        final float x = body.getPosition().x;
        final float y = body.getPosition().y;
        final float angle = body.getAngle();
        drawable.draw(batch, x, y, angle, 1f);
    }

    public void setDrawable(IDrawable drawable) {
        this.drawable = drawable;
    }
}
