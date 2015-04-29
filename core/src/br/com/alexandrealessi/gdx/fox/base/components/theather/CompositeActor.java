package br.com.alexandrealessi.gdx.fox.base.components.theather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 26/04/15.
 */
public class CompositeActor implements Entity {

    private Array<Entity> childs = new Array<Entity>();

    @Override
    public final void act(float delta) {
        for (Entity child : childs) {
            child.act(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch, float alpha) {
        for (Entity child : childs) {
            child.draw(batch, alpha);
        }
    }

    public void addChild(Entity child) {
        childs.add(child);

    }

    public void removeChild(Entity child) {
        childs.removeValue(child, true);
    }

}
