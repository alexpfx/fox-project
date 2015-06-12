package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 24/05/15.
 */
    public class PositionComponent extends Component {
        public static final ComponentMapper<PositionComponent> POSITION = ComponentMapper.getFor(PositionComponent.class);

        private Vector2 position = new Vector2();
        private float rotation;

        private PositionComponent() {
        }

        public static PositionComponent newInstance() {
            return new PositionComponent();
        }

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
