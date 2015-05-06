package br.com.alexandrealessi.gdx.fox.base.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.MovableEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.VisualEntity;
import br.com.alexandrealessi.gdx.fox.base.utils.CameraHandler;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size.*;

/**
 * Created by alex on 01/05/2015.
 */
public abstract class Stage implements InputProcessor {

    private Array<MovableEntity> movableEntities;
    private Array<VisualEntity> visualEntities;
    private SpriteBatch batch;
    private WorldRenderer worldRenderer;
    private CameraHandler cameraHandler;

    public abstract void init ();

    public void resize (float width, float height){
        worldRenderer.resize(width, height);

        final float AR = (float) Gdx.graphics.getWidth() /  Gdx.graphics.getHeight();

        cameraHandler.getCamera().viewportHeight = height;
        cameraHandler.getCamera().viewportWidth = AR * height;
        cameraHandler.getCamera().update();
    }

    public Stage(float width, float height){
        OrthographicCamera camera = new OrthographicCamera(width, height);
        camera.position.set(width / 2f, height / 2f, 0);
        camera.update();
        camera.zoom = CAMERA_ZOOM.value();
        cameraHandler = new CameraHandler(camera);
        movableEntities = new Array<MovableEntity>();
        visualEntities = new Array<VisualEntity>();
        batch = new SpriteBatch();

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
