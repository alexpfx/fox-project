package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 24/05/15.
 */
//TODO: mover de volta para o pacote especifico.
public class PositionComponent extends Component {
    private Vector2 position = new Vector2();
    private float rotation;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setPosition(float x, float y, float rotation) {
        position.x = x;
        position.y = y;
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "x: " + position.x + ",y: " + position.y;
    }
}
