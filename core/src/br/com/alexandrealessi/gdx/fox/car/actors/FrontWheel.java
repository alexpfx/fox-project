package br.com.alexandrealessi.gdx.fox.car.actors;

import br.com.alexandrealessi.gdx.fox.base.IDrawable;
import br.com.alexandrealessi.gdx.fox.base.actors.ActorPart;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/04/15.
 */
public class FrontWheel extends ActorPart {

    public FrontWheel(Body body, IDrawable drawable) {
        super(body);
        setDrawable(drawable);
    }

    public FrontWheel(Body body) {
        super(body);
    }

}
