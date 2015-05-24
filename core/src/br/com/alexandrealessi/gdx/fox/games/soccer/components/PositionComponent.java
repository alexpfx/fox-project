package br.com.alexandrealessi.gdx.fox.games.soccer.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 24/05/15.
 */
public class PositionComponent extends Component {
    private float x;
    private float y;
    private float angle;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAngle() {
        return angle;
    }
}
