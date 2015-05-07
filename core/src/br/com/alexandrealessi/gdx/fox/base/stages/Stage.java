package br.com.alexandrealessi.gdx.fox.base.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.*;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenContext;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.*;

/**
 *
 */
public abstract class Stage implements InputProcessor {



    private Array<MovableEntity> movableEntities;
    private Array<VisualEntity> visualEntities;
    private Array<PhysicObject> physicObjects;
    private SpriteBatch batch;
    private WorldRenderer worldRenderer;
    private CameraHandler cameraHandler;

    public abstract void init ();
    protected WorldContext worldContext;
    protected ScreenContext screenContext;

    public void resize (float width, float height){
        worldRenderer.resize(width, height);

        final float AR = (float) Gdx.graphics.getWidth() /  Gdx.graphics.getHeight();

        cameraHandler.getCamera().viewportHeight = height;
        cameraHandler.getCamera().viewportWidth = AR * height;
        cameraHandler.getCamera().update();
    }

    public Stage(ScreenContext screenContext, WorldContext worldContext){
        this.worldContext = worldContext;
        this.screenContext = screenContext;
        final float width = screenContext.getWidth();
        final float height = screenContext.getHeight();
        OrthographicCamera camera = new OrthographicCamera(width, height);
        camera.position.set(width / 2f, height / 2f, 0);
        camera.update();
        camera.zoom = CAMERA_ZOOM.value();
        cameraHandler = new CameraHandler(camera);
        movableEntities = new Array<MovableEntity>();
        visualEntities = new Array<VisualEntity>();
        batch = new SpriteBatch();
        physicObjects = new Array<PhysicObject>();
    }

    public final void addPhysicObject (PhysicObject object){
        physicObjects.add(object);
    }

    public final void addMovable(MovableEntity entity) {
        movableEntities.add(entity);
    }

    public void setWorldRenderer(WorldRenderer worldRenderer) {
        this.worldRenderer = worldRenderer;
    }

    public final void addVisual(VisualEntity entity) {
        visualEntities.add(entity);
    }

    public final void addEntity(Entity entity) {
        if (entity instanceof VisualEntity) {
            visualEntities.add((VisualEntity) entity);
        }
        if (entity instanceof MovableEntity) {
            movableEntities.add((MovableEntity) entity);
        }
    }

    public final void render() {
        handleInput();
        update();
        draw();
        if (worldRenderer != null)
            worldRenderer.render();
    }

    protected void handleInput(){

    }

    private void draw() {
        cameraHandler.render();
//        Camera camera = viewPort.getCamera();
//        camera.update();
//        batch.setProjectionMatrix(viewPort.getCamera().combined);
        batch.setProjectionMatrix(cameraHandler.getCamera().combined);
        batch.begin();
        for (VisualEntity e : visualEntities) {
            e.draw(batch, .5f);
        }
        batch.end();
    }

    private void update() {
        for (MovableEntity e : movableEntities) {
            e.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void dispose() {
        for (MovableEntity e : movableEntities) {
            e.dispose();
        }
        for (VisualEntity v : visualEntities) {
            v.dispose();
        }

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

}
