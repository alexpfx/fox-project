package br.com.alexandrealessi.gdx.fox.car;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarGameConstants {

    public static enum Flags {

        DEBUG_PHYSICS(true);

        private final boolean value;

        private Flags(boolean value) {
            this.value = value;
        }

        public boolean value() {
            return value;
        }

    }

    public static enum Sizes {

        WORLD(new Vector2(80f, 48f)), SCREEN(new Vector2(800f, 480f));

        private Vector2 value;

        private Sizes(Vector2 value) {
            this.value = value;
        }

        public float width() {
            return value.x;
        }

        public float height() {
            return value.y;
        }

        public float hratio(Sizes sizes) {
            return value.scl(1 / height()).x;
        }

        public Vector2 value() {
            return value;
        }

    }

}
