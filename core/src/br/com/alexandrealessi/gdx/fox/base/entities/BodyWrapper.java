package br.com.alexandrealessi.gdx.fox.base.entities;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alex on 01/05/2015.
 */
public class BodyWrapper {

    private Body body;

    public BodyWrapper(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }
}
