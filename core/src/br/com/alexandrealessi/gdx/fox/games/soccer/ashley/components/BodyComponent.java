package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.base.UserData;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeDefaults;

/**
 * Created by alexandre on 24/05/15.
 */
public class BodyComponent extends Component implements UserData {
    private Body body;
    private boolean isAlive;

    private BodyComponent(Body body) {
        this.body = body;
    }

    public static BodyComponent newInstance(Body body) {
        return new BodyComponent(body);
    }

    public Body getBody() {
        return body;
    }

    @Override
    public boolean canDestroy() {
        return !isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
