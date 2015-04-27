package br.com.alexandrealessi.gdx.fox.games.race.actors;

import br.com.alexandrealessi.gdx.fox.base.components.IDrawable;
import br.com.alexandrealessi.gdx.fox.base.components.ActorComponent;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/04/15.
 */
public class FrontWheel extends ActorComponent {

    public FrontWheel(Body body, IDrawable drawable) {
        super(body, drawable);
    }

    public FrontWheel(Body body) {
        super(body);
    }

}
