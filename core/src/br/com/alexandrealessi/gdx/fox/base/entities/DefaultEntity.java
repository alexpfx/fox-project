package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alex on 01/05/2015.
 */
public class DefaultEntity implements Physical, VisualEntity {

    private BodyWrapper body;
    private Drawable drawable;
    private Array<Script> scripts;
    private SpriteBatch batch;


    @Override
    public BodyWrapper getBody() {
        return body;
    }


    @Override
    public void update(float delta) {
        for (Script script : scripts) {
            script.run(delta);
        }
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
