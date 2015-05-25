package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.screens.Screen;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.systems.Box2dWorldSystem;
import br.com.alexandrealessi.gdx.fox.games.soccer.systems.PhysicToScreenSystem;
import br.com.alexandrealessi.gdx.fox.games.soccer.systems.RenderSystem;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends Screen {
    //1248 x 794
    private static final float SCENE_WIDTH = 160;
    private static final float SCENE_HEIGHT = 100;
    private static final float ASPECT_RATIO = SCENE_WIDTH / SCENE_HEIGHT;

    private Engine engine;
    private Entity player;
    private Entity field;
    private TextureAtlas atlas;
    private RubeSceneWrapper rubeSceneWrapper;
    private OrthographicCamera camera;
    private OrthographicCamera worldCamera;
    private Viewport viewport;
    private Viewport worldViewport;

    public GamePlayScreen(SoccerGame game) {
        super(game);
        atlas = new TextureAtlas(Gdx.files.internal("data/images/game.atlas"));
        rubeSceneWrapper = new RubeSceneWrapper("soccer.json");
        engine = new Engine();
        player = new Entity();

        player.add(new BodyComponent(rubeSceneWrapper.getBody("player")));
        player.add(new PositionComponent());

        final Sprite panda = new Sprite(atlas.findRegion("panda"));
        panda.setScale(2.2f / panda.getHeight());
        player.add(new SpriteComponent(panda));

        field = new Entity();
        field.add(new BodyComponent(rubeSceneWrapper.getBody("field")));
        field.add(new PositionComponent());

        final Sprite soccer = new Sprite(atlas.findRegion("soccer"));
        soccer.setScale(100 / soccer.getHeight());
        field.add(new SpriteComponent(soccer));

        camera = new OrthographicCamera();
        worldCamera = new OrthographicCamera();

        viewport = new StretchViewport(SCENE_WIDTH, SCENE_HEIGHT, camera);

        Box2dWorldSystem box2dWorldSystem = new Box2dWorldSystem(rubeSceneWrapper.getWorld(), viewport);
        PhysicToScreenSystem physicToScreenSystem = new PhysicToScreenSystem(1);
        RenderSystem renderSystem = new RenderSystem(viewport);

        engine.addEntity(field);
        engine.addEntity(player);
        engine.addSystem(physicToScreenSystem);
        engine.addSystem(renderSystem);
        engine.addSystem(box2dWorldSystem);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
//        worldViewport.update(width, height);
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }
}
