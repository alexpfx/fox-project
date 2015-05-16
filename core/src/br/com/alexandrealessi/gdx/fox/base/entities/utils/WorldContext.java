package br.com.alexandrealessi.gdx.fox.base.entities.utils;

/**
 * Created by alexandre on 06/05/15.
 */
public class WorldContext {
    private final float width;
    private final float height;

    private WorldContext(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public static WorldContext createNew(float width, float height) {
        return new WorldContext(width, height);
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
