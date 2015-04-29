package br.com.alexandrealessi.gdx.fox.base.components.theather;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 26/04/15.
 */
public abstract class CompositeActor implements Entity {


    private Array<Entity> childs = new Array<Entity> ();

    @Override
    public final void act(float delta) {
        for (Entity child:childs){
            child.act(delta);
        }
    }


}
