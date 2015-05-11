package br.com.alexandrealessi.gdx.fox.base.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableCameraPositioner;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraPositioner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.CAMERA_ZOOM;

/**
 *
 */
public abstract class PlayableStage implements InputProcessor, Stage {


    public static final String KMH_KEY = "kmh";
    private Array<Entity> entities;
    private SpriteBatch batch;
    private WorldRenderer worldRenderer;
    private CameraHolder cameraHandler;
    private CameraPositioner positioner;

    protected WorldContext worldContext;
    protected WorldContext screenContext;

    public WorldContext getWorldContext() {
        return worldContext;
    }

    public WorldContext getScreenContext() {
        return screenContext;
    }

    public PlayableStage(WorldContext screenContext, WorldContext worldContext) {
        this.worldContext = worldContext;
        this.screenContext = screenContext;
        cameraHandler = new CameraHolder(new OrthographicCamera(), screenContext.getWidth(), screenContext.getHeight(), CAMERA_ZOOM.value());
        batch = new SpriteBatch();
        entities = new Array<Entity>();
        positioner = new DrawableCameraPositioner();

    }

    public void setWorldRenderer(WorldRenderer worldRenderer) {
        this.worldRenderer = worldRenderer;
    }

    public final void addEntity(Entity entity) {
        entities.add(entity);
    }

    @Override
    public final void render() {
        handleInput();
        update();
        draw();
        if (worldRenderer != null)
            worldRenderer.render();
    }

    protected void handleInput() {

    }

    private void draw() {
        positioner.update();
        cameraHandler.update();
        batch.setProjectionMatrix(cameraHandler.getCombinedProjectionMatrix());
        batch.begin();
        for (Entity e : entities) {
            e.draw(batch, 1f);
        }
        batch.end();
    }


    protected void afterUpdate (){

    }

    private void update() {
        for (Entity e : entities) {
            e.update(Gdx.graphics.getDeltaTime());
        }
        afterUpdate();

    }

    @Override
    public void dispose() {

    }

    // Input

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void pointCameraTo (Entity entity){
        positioner.setCamera(cameraHandler).lookAt(entity);
        worldRenderer.lookAt(entity);
    }

}
