package br.com.alexandrealessi.gdx.fox.games.topdown;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenUtils;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.topdown.stages.GameStage;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cookbook.box2d.MapBodyManager;

import static com.badlogic.gdx.graphics.Color.BLACK;

/**
 * Created by alexandre on 16/05/15.
 */
public class TopDownRaceGame extends BaseGame {
    private GameStage gameStage;

    private static final float SCREEN_TO_WORLD = 30f;
    private static final float WORLD_TO_SCREEN = 1/SCREEN_TO_WORLD;
    private static final float SCENE_WIDTH = 1200.80f; // 12.8 metres wide
    private static final float SCENE_HEIGHT = 1200.20f; // 7.2 metres high

    private Viewport viewport;
    private SpriteBatch batch;

    Box2DDebugRenderer debugRenderer;
    World world;

    TiledMap map;
    private OrthographicCamera camera;

    private TmxMapLoader loader;

    private MapRenderer render;
    private MapBodyManager mapBodyManager;
    public TopDownRaceGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        loader = new TmxMapLoader();
        map = loader.load("track1.tmx");
        render = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(true, SCENE_WIDTH, SCENE_HEIGHT);
    }

    @Override
    public void render() {
        ScreenUtils.clear(BLACK);
        camera.position.set(1200,1200,0);
        camera.zoom = 4.5f;
        camera.update();

        render.setView(camera);
        render.render();
    }
}
