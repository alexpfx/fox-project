package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Created by alexandre on 09/06/15.
 */
public class FixtureUserDataComposite {

    private FixtureDef fixtureDef;
    private Object userData;


    private  FixtureUserDataComposite(FixtureDef fixtureDef, Object userData) {
        this.fixtureDef = fixtureDef;
    }

    public static FixtureUserDataComposite newInstance(FixtureDef fixtureDef, Object userData) {
        return new FixtureUserDataComposite(fixtureDef, userData);
    }

    public FixtureDef getFixtureDef() {
        return fixtureDef;
    }

    public Object getUserData() {
        return userData;
    }
}
