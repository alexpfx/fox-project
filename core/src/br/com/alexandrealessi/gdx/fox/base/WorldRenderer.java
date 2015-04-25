package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by alexandre on 25/04/15.
 */
public class WorldRenderer {

    public static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 10;
    private static final int POSITION_ITERATIONS = 7;

    private final World world;
    private final OrthographicCamera camera;
    private final Box2DDebugRenderer debugRenderer;

    public WorldRenderer(World world, float width, float height) {
        this.world = world;
        camera = new OrthographicCamera(width, height);

        debugRenderer = new Box2DDebugRenderer();
    }

    public void render() {
        camera.update();
        debugRenderer.render(world, camera.combined);
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

}
