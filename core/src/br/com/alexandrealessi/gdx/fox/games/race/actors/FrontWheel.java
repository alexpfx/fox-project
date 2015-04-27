package br.com.alexandrealessi.gdx.fox.games.race.actors;

import br.com.alexandrealessi.gdx.fox.base.components.IDrawable;
import br.com.alexandrealessi.gdx.fox.base.components.ActorPart;
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
