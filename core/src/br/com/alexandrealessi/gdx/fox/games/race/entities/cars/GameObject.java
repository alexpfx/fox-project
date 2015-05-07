package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 06/05/15.
 */
public abstract class GameObject implements Entity {

    protected RigidBody body;
    private Drawable drawable;

    public GameObject(RigidBody body) {
        this.body = body;
    }

    public GameObject(RigidBody body, Drawable drawable) {
        this(body);
        this.drawable = drawable;
        body.addOnMoveListener(drawable);
    }

    @Override
    public void update (float delta){
        body.update();
    }


    @Override
    public void draw(SpriteBatch batch, float alpha) {
        if (drawable != null){
            drawable.draw(batch, alpha);
        }
    }


    public void dispose() {

    }
}
