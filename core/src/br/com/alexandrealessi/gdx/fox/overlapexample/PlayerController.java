package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.physics.box2d.Body;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.script.IScript;

/**
 * Created by alexandre on 25/04/15.
 */
public class PlayerController implements IScript {
    private CompositeItem item;
    private Body body;
    @Override
    public void init(CompositeItem item) {
        this.item = item;
        this.body = item.getBody();
        body.setLinearVelocity(-10, 0);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void act(float delta) {

    }
}
