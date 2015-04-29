package br.com.alexandrealessi.gdx.fox.base.components.theather;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 28/04/15.
 */
public final class Actor implements Entity {

    private Array<Script> actuations = new Array<Script>();

    @Override
    public void act(float delta) {
        for (Script s : actuations) {
            s.act(delta);
        }
    }

    public void addScript(Script script) {
        actuations.add(script);
    }

    public void removeScript(Script script) {
        actuations.removeValue(script, true);
    }

}
