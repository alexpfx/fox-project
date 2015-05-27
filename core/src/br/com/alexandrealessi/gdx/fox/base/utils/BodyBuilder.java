package br.com.alexandrealessi.gdx.fox.base.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 25/05/15.
 */
//TODO: refatorar
public class BodyBuilder {

    private Body body;
    private BodyDef bdef;
    private Array<FixtureDef> fixtureDefs;
    private Object userData;
    private World world;

    private BodyBuilder() {
        bdef = new BodyDef();
    }

    public static BodyBuilder create() {
        return new BodyBuilder();
    }

    public static BodyBuilder create(World world) {
        final BodyBuilder bodyBuilder = new BodyBuilder();
        bodyBuilder.world = world;
        return bodyBuilder;
    }

    public static BodyBuilder clone(Body body, World world) {
        BodyBuilder bb = create(world).bodyType(body.getType())
                                      .position(body.getPosition())
                                      .fixedRotation(body.isFixedRotation())
                                      .active(body.isActive())
                                      .bullet(body.isBullet())
                                      .userData(body.getUserData());
        Array<Fixture> fixtureList = body.getFixtureList();
        for (Fixture f : fixtureList) {
            bb.addFixture(FixtureBuilder.create()
                                        .clone(f));
        }
        return bb;
    }

    public static BodyBuilder clone(Body body) {
        return clone(body, body.getWorld());
    }

    public BodyBuilder bodyType(BodyDef.BodyType bodyType) {
        bdef.type = bodyType;
        return this;
    }

    public BodyBuilder position(final Vector2 position) {
        bdef.position.set(position.x, position.y);
        return this;
    }

    public BodyBuilder fixedRotation(boolean fixed) {
        bdef.fixedRotation = fixed;
        return this;
    }

    public BodyBuilder active(boolean active) {
        bdef.active = active;
        return this;
    }

    public BodyBuilder bullet(boolean bullet) {
        bdef.bullet = bullet;
        return this;
    }

    public BodyBuilder userData(Object userData) {
        this.userData = userData;
        return this;
    }

    public BodyBuilder addFixture(FixtureDef fdef) {
        if (fixtureDefs == null)
            fixtureDefs = new Array<FixtureDef>();
        fixtureDefs.add(fdef);
        return this;
    }

    public Body build() {
        return build(this.world);
    }

    public Body build(World world) {
        body = world.createBody(bdef);
        if (fixtureDefs != null) {
            for (FixtureDef d : fixtureDefs) {
                body.createFixture(d);
            }
        }
        body.setUserData(userData);
        return body;
    }
}
