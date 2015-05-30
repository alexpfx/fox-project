package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 29/05/15.
 */
public class Box2dUtils {

    public static float vectorToAngle (Vector2 vector) {
        return (float)Math.atan2(-vector.x, vector.y);
    }

    public static Vector2 angleToVector (Vector2 outVector, float angle) {
        outVector.x = -(float)Math.sin(angle);
        outVector.y = (float)Math.cos(angle);
        return outVector;
    }

}
