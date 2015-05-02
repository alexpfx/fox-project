package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyWrapper;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alex on 01/05/2015.
 */
public abstract class DefaultEntity implements MovableEntity, VisualEntity, PhysicalEntity {

    private BodyWrapper body;
    private Drawable drawable;
    private final Array<Script> scripts;

    public DefaultEntity() {
        this.scripts = new Array<Script>();
    }

    public void addScript(Script script) {
        scripts.add(script);
    }

    @Override
    public void setBodyWrapper(BodyWrapper body) {
        this.body = body;
    }

    @Override
    public BodyWrapper getBodyWrapper() {
        return body;
    }

    @Override
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void update(float delta) {
        for (Script script : scripts) {
            script.run(delta);
        }
    }

    public BodyWrapper getBody() {
        return body;
    }


    @Override
    public void draw(SpriteBatch batch, float alpha) {
        if (body == null || drawable == null)
            return;
        Body b = body.getBody();
        drawable.draw(batch, alpha, b.getPosition(), b.getAngle() * MathUtils.radDeg);
    }


    @Override
    public void dispose() {

    }
}
