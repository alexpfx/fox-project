package br.com.alexandrealessi.gdx.fox.car;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarGameConstants {

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

        WORLD(new Vector2(23.66f, 14.201f)), SCREEN(new Vector2(800f, 480f));

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

        public float yTo(float y, Sizes target) {
            return (target.height()/height()) * y;
        }

        public float xTo(float x, Sizes target) {
            return (target.width()/width()) * x;
        }

    }

}
