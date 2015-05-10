package br.com.alexandrealessi.gdx.fox.base.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.PhysicalCameraPositioner;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraPositioner;
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
    private final WorldContext context;
    private CameraHolder cameraHolder;
    private final Box2DDebugRenderer debugRenderer;
    private CameraPositioner<Entity> cameraPositioner;


    public WorldRenderer(World world, WorldContext context) {
        this.world = world;
        this.context = context;
        cameraHolder = new CameraHolder(new OrthographicCamera(), context.getWidth(), context.getHeight(), Size.CAMERA_ZOOM.value());
        cameraHolder.setPosition(0,0);
        debugRenderer = new Box2DDebugRenderer();
        cameraPositioner = new PhysicalCameraPositioner();
    }

    public void setCameraHolder(OrthographicCamera cameraHolder) {
        this.cameraHolder = this.cameraHolder;
    }

    public Box2DDebugRenderer getDebugRenderer() {
        return debugRenderer;
    }

    public void render() {
        cameraPositioner.update();
        cameraHolder.update();

        if (FlagConstants.DEBUG_PHYSICS.value) {
            debugRenderer.render(world, cameraHolder.getCombinedProjectionMatrix());
        }
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }



//    public void resize (float width, float height){
//        float hw = Size.SCREEN.convert(Size.WORLD, height);
//        float w = Gdx.graphics.getWidth();
//        float h = Gdx.graphics.getHeight();
//
//        cameraHolder.viewportHeight = hw;
//        cameraHolder.viewportWidth = (w/h) * hw;
//        cameraHolder.update();
//    }

    public void lookAt (Entity entity){
        cameraPositioner.setCamera(cameraHolder).lookAt(entity);
    }
}
