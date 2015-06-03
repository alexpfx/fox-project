package br.com.alexandrealessi.gdx.fox.base.utils;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by alexandre on 02/06/15.
 */
public class StopWatch {

    private static long time;
    private static long nanoTime;

    public static void start() {
        time = TimeUtils.millis();
    }

    public static long elapsed() {
        return TimeUtils.timeSinceMillis(time);
    }

    public static void startNanos() {
        nanoTime = TimeUtils.nanoTime();
    }

    public static long elapsedNanos() {
        return TimeUtils.timeSinceNanos(nanoTime);
    }

    public static final float elapsedSeconds (){
        return TimeUtils.timeSinceMillis(time) * 0.001f;
    }

}
