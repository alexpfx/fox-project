package br.com.alexandrealessi.gdx.fox.base.stages;

import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.FlagConstants;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
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
    private OrthographicCamera camera;
    private final Box2DDebugRenderer debugRenderer;


    public WorldRenderer(World world, Vector2 size) {
        this.world = world;
        camera = new OrthographicCamera(size.x, size.y);
        debugRenderer = new Box2DDebugRenderer();
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Box2DDebugRenderer getDebugRenderer() {
        return debugRenderer;
    }



    public void render() {
        camera.zoom = Size.CAMERA_ZOOM.value();
        camera.position.set(0, 0, 1f);
        camera.update();
        if (FlagConstants.DEBUG_PHYSICS.value) {
            debugRenderer.render(world, camera.combined);
        }
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }


    public void resize (float width, float height){
        float hw = Size.SCREEN.convert(Size.WORLD, height);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera.viewportHeight = hw;
        camera.viewportWidth = (w/h) * hw;
        camera.update();
    }

    public void lookAt (float x, float y){
        camera.position.set(x, y, 0);
        camera.update();
    }
}
