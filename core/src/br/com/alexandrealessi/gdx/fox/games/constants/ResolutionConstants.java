package br.com.alexandrealessi.gdx.fox.games.constants;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 30/04/15.
 */
public enum ResolutionConstants {
    WORLD(new Vector2(25.806f * 1.32f, 15.48f * 1.32f)), SCREEN(new Vector2(800f, 480f));
    //    WORLD(new Vector2(25.806f * 1.5f, 15.48f * 1.5f)), SCREEN(new Vector2(800f, 480f));
    public Vector2 value;
    private Vector2 inputValue;
    private Vector2 sourceValue;

    private ResolutionConstants(Vector2 value) {
        this.value = value;
    }

    /**
     * Alternative Transform method.
     */
    public static class Transform {
        private Vector2 inputValue;
        private Vector2 sourceValue;

        private final static Transform instance = new Transform();

        private Transform() {

        }

        public static Transform value(Vector2 inputValue) {
            instance.inputValue = inputValue;
            return instance;
        }

        public Transform from(ResolutionConstants size) {
            this.sourceValue = size.value;
            return this;
        }

        public Vector2 to(ResolutionConstants size) {
            float x = size.value.x / sourceValue.x * inputValue.x;
            float y = size.value.y / sourceValue.y * inputValue.y;
            return Vector2.Zero.set(x, y);
        }

        public static void main(String[] args) { // Test
            final Vector2 transfomed = Transform.value(new Vector2(10, 10)).from(WORLD).to(SCREEN);
        }
    }
}
