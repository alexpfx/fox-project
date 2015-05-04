package br.com.alexandrealessi.gdx.fox.games.race.stages.constants;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 03/05/15.
 */
//interface Conversor {
//    float convertTo(float convertValue, Heights h);
//}

public enum Heights {

    ZOOM (5F),
    SCREEN(480f),
    WORLD(20.4336f);

    private static final float H_TO_W = 1.6666666667f;

    private Heights(float height) {
        this.height = height;
    }

    private float height;

    public float convertTo(Heights target, float convertValue) {
        return target.height / this.height * convertValue;
    }

    public Vector2 convertTo(Heights target, Vector2 convertValue) {
        return convertValue.scl(target.height / this.height);
    }

    public float height() {
        System.out.println(height);
        return height;
    }

    public float width() {
        return this.height * H_TO_W;
    }

    public static void main(String[] args) {
        final float v = SCREEN.convertTo(WORLD, 10);
        System.out.println(v); //
    }

}
