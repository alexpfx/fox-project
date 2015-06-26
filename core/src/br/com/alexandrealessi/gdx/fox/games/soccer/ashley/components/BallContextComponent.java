package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 21/06/15.
 */
public class BallContextComponent extends Component {

    private BallContextComponent() {
    }

    public static BallContextComponent newInstance() {
        return new BallContextComponent();
    }
}
