package br.com.alexandrealessi.gdx.fox.base.components.theather;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 28/04/15.
 */
public final class Actor implements Entity {

    private final Body body;
    private Array<Script> actuations = new Array<Script>();
    private Drawable drawable;

    public Actor(Body body) {
        this.body = body;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public final void act(float delta) {
        for (Script s : actuations) {
            s.act(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        if (drawable != null) {
            drawable.draw(batch, alpha, body.getPosition(), body.getAngle() * MathUtils.radDeg);
        }
    }

    public void addScript(Script script) {
        actuations.add(script);
    }

    public void removeScript(Script script) {
        actuations.removeValue(script, true);
    }

    @Override
    public Vector2 getWorldPosition() {
        return body.getWorldCenter();
    }

    public Body getBody() {
        return body;
    }
}
