package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.physics.PhysicsBodyLoader;
import com.uwsoft.editor.renderer.script.IScript;

/**
 * Created by alexandre on 25/04/15.
 */
public class CarController implements IScript {
    private CompositeItem item;
    private Body body;
    final float WORLD_TO_SCREEN = 31.5f;

    @Override
    public void init(CompositeItem item) {
        this.item = item;
        this.body = item.getBody();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void act(float delta) {


        final float x = body.getPosition().x * WORLD_TO_SCREEN + 400 - (item.getWidth() / 2 ) ;
        final float y = body.getPosition().y * WORLD_TO_SCREEN + 240 - (item.getHeight() / 2) ;

        item.setPosition(x, y);
    }
}
