package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Created by alexandre on 09/06/15.
 */
public class FixtureCloner {

    private FixtureCloner() {
    }

    public static FixtureCloner newInstance() {
        return new FixtureCloner();
    }

    private FixtureDef createFixtureDef(Fixture fixture) {
        FixtureDef def = new FixtureDef();
        def.density = fixture.getDensity();
        def.friction = fixture.getFriction();
        def.isSensor = fixture.isSensor();
        def.restitution = fixture.getRestitution();
        def.shape = fixture.getShape();
        return def;
    }

    public FixtureUserDataComposite clone(Fixture fixture) {
        final Body body = fixture.getBody();
        final FixtureUserDataComposite fixtureUserDataComposite = FixtureUserDataComposite
                .newInstance(createFixtureDef(fixture), fixture.getUserData());
        return fixtureUserDataComposite;
    }



}
