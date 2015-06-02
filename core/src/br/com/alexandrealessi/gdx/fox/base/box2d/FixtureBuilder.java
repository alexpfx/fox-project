package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

//TODO: refatorar
public class FixtureBuilder {
    private FixtureDef def;
    private Object userData;

    private FixtureBuilder() {
        def = new FixtureDef();
    }

    public static FixtureBuilder create() {
        return new FixtureBuilder();
    }

    public FixtureBuilder density(float value) {
        def.density = value;
        return this;
    }

    public FixtureBuilder friction(float value) {
        def.friction = value;
        return this;
    }

    public FixtureBuilder userData(Object userData) {
        this.userData = userData;
        return this;
    }

    public FixtureBuilder restitution(float value) {
        def.restitution = value;
        return this;
    }

    public FixtureBuilder sensor(boolean value) {
        def.isSensor = value;
        return this;
    }

    public FixtureBuilder shape(Shape shape) {
        def.shape = shape;
        return this;
    }

    public Fixture build(Body body) {
        return body.createFixture(def);
    }

    public FixtureDef getFixtureDef() {
        return this.def;
    }

    //TODO: codigo duplicado
    public Fixture clone(Fixture fixture, Body body) {
        final Fixture f = create().density(fixture.getDensity())
                                  .friction(fixture.getFriction())
                                  .restitution(fixture.getRestitution())
                                  .shape(fixture.getShape())
                                  .sensor(fixture.isSensor())
                                  .build(body);
        f.setUserData(fixture.getUserData());
        return f;
    }

    //TODO: codigo duplicado
    public FixtureDef clone(Fixture fixture) {
        return create().userData(fixture.getUserData())
                       .density(fixture.getDensity())
                       .friction(fixture.getFriction())
                       .restitution(fixture.getRestitution())
                       .shape(fixture.getShape())
                       .sensor(fixture.isSensor()).def;
    }

}
