package br.com.alexandrealessi.gdx.fox.games.soccer.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 24/05/15.
 */
public class Box2dWorldSystem extends EntitySystem{
    public static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 3;
    private static final int POSITION_ITERATIONS = 2;

    private final World world;
    private Box2DDebugRenderer debugRenderer;
    private static final boolean debugPhysics = false;
    private Viewport viewport;

    public Box2dWorldSystem (World world, Viewport viewport){
        this.world = world;
        this.viewport = viewport;
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        final Camera camera = viewport.getCamera();
        camera.update();
        if (debugPhysics){
            debugRenderer.render(world, camera.combined);
        }
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }
}