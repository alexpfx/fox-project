package br.com.alexandrealessi.gdx.fox.games.race.stages.constants;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 03/05/15.
 */
//interface Conversor {
//    float convert(float convertValue, Heights h);
//}

public enum Size {

    ZOOM (5f),
    SCREEN(480f),
    WORLD(20.4336f),
    ASPECT_RATIO (1.666666666667f);

    private Size(float value) {
        this.value = value;
    }

    private float value;

    public float convert(Size target, float convertValue) {
        return target.value / this.value * convertValue;
    }

    public Vector2 convert(Size target, Vector2 convertValue) {
        return convertValue.scl(target.value / this.value);
    }

    public float value() {
        return value;
    }

    public float scale(float value) {
        return this.value * ASPECT_RATIO.value();
    }

    public static void main(String[] args) {
        final float v = SCREEN.convert(WORLD, 10);
        System.out.println(v); //
    }

}
