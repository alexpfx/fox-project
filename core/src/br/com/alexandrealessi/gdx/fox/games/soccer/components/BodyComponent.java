package br.com.alexandrealessi.gdx.fox.games.soccer.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class BodyComponent extends Component {
    private Body body;

    private BodyComponent (Body body){
        this.body = body;
    }

    public Body getBody() {
        return body;
    }
}
