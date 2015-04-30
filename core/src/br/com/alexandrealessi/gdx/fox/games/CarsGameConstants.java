package br.com.alexandrealessi.gdx.fox.games;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsGameConstants {

    public static enum Strings {
        GAME_ATLAS_NAME("game.atlas"),
        GUI_ATLAS_NAME("gui.atlas");

        public final String value;

        private Strings(String value) {
            this.value = value;
        }
    }

    public static enum Flags {

        DEBUG_PHYSICS(true);

        public final boolean value;

        private Flags(boolean value) {
            this.value = value;
        }

    }

    public static enum Sizes {
        WORLD(new Vector2(25.806f, 15.48f)), SCREEN(new Vector2(800f, 480f)), TRANSFORM(new Vector2(-1, -1));

        private Vector2 value;

        private Sizes(Vector2 value) {
            this.value = value;
        }

        private Vector2 inputValue;
        private Vector2 sourceValue;

        public Sizes value(Vector2 value) {
            inputValue = value;
            return this;
        }

        public Sizes from(Sizes size) {
            sourceValue = size.value;
            return this;
        }

        public Vector2 to(Sizes size) {
            float x = size.value.x / sourceValue.x * inputValue.x;
            float y = size.value.y / sourceValue.y * inputValue.y;
            return Vector2.Zero.set(x, y);
        }

        public Vector2 getValue() {
            return value;
        }
    }


    /*
    public static enum Sizes {

        WORLD(new Vector2(25.806f, 15.48f)), SCREEN(new Vector2(800f, 480f));

        public Vector2 value;

        private Sizes(Vector2 value) {
            this.value = value;
        }

        public float width() {
            return value.x;
        }

        public float height() {
            return value.y;
        }

        public float scaleY(float y, Sizes target) {
            return (target.height() / height()) * y;
        }

        public float scaleX(float x, Sizes target) {
            return (target.width() / width()) * x;
        }

    }
    */

}
