package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.sun.istack.internal.NotNull;

/**
 * Created by alex on 01/05/2015.
 */
public abstract class DefaultEntity implements MovableEntity, VisualEntity {

    private final BodyWrapper body;
    private final Drawable drawable;
    private final Array<Script> scripts;

    public DefaultEntity(BodyWrapper bodyWrapper, Drawable drawable) {
        this.scripts = new Array<Script>();
        this.body = bodyWrapper;
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
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        Body b = body.getBody();
        drawable.draw(batch, alpha, b.getPosition(), b.getAngle() * MathUtils.radDeg);
    }


}
