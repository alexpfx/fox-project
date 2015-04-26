package br.com.alexandrealessi.gdx.fox.base.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by alexandre on 26/04/15.
 */
public abstract class ActorPart extends Actor {

    final protected Body body;

    public ActorPart(Body body) {
        this.body = body;
    }

}
