package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeDefaults;

/**
 * Created by alexandre on 24/05/15.
 */
public class BodyComponent extends Component{
    private Body body;
    

    public BodyComponent(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

}
