package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.base.screens.BaseScreen;
import br.com.alexandrealessi.gdx.fox.base.utils.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.base.utils.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchContextComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems.*;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends BaseScreen implements InputProcessor{
    //1248 x 794
    //1700 x 1150

    public static final int PIXEL_TO_METER_FACTOR = 1;
    public static final boolean DEBUG_PHYSICS = true;
    public static final float CAMERA_ZOOM = 0.6f;
    public static final String DATA_IMAGES_GAME_ATLAS = "data/images/game.atlas";
    public static final String SOCCER_JSON = "soccer.json";
    public static final String FIELD_BODY_NAME = "field";
    private static final float SCENE_WIDTH = 178f;
    private static final float SCENE_HEIGHT = 120;
    private static final float ANIMAL_SPRITE_SCALE = 7F;
    private static final Rectangle SCENE_BOUNDS = new Rectangle(-SCENE_WIDTH, -SCENE_HEIGHT, SCENE_WIDTH, SCENE_HEIGHT);
    private TouchDownInputComponent touchDownInputComponent;
    private Engine engine;
    private TextureAtlas atlas;
    private RubeSceneHelper rubeSceneHelper;
    private OrthographicCamera camera;
    private Viewport viewport;

    public GamePlayScreen(SoccerGame game) {
        super(game);
        engine = new Engine();
        setupViewport();
        setupInput();
        createResourceHelperObjects();
        createWorld();
        createField();
        createBall();
        createTeams();
        createSystems();
    }

    private void setupInput() {
        Entity input = new Entity();
        Gdx.input.setInputProcessor(this);

        this.touchDownInputComponent = new TouchDownInputComponent();
        input.add(touchDownInputComponent);

        input.add(new CameraComponent(viewport.getCamera()));

        engine.addEntity(input);
    }

    private void setupViewport() {
        camera = new OrthographicCamera();
        camera.zoom = CAMERA_ZOOM;
        viewport = new StretchViewport(SCENE_WIDTH, SCENE_HEIGHT, camera);
    }

    private void createResourceHelperObjects() {
        atlas = new TextureAtlas(Gdx.files.internal(DATA_IMAGES_GAME_ATLAS));
        rubeSceneHelper = new RubeSceneHelper(SOCCER_JSON);
    }

    public void createField() {
        Entity field = new Entity();

        field.add(new BodyComponent(rubeSceneHelper.getBody(FIELD_BODY_NAME)));
        field.add(new PositionComponent());

        final Sprite soccer = new Sprite(atlas.findRegion("small_field"));
        soccer.setScale(SCENE_HEIGHT / soccer.getHeight());
        field.add(new SpriteComponent(soccer));

        engine.addEntity(field);
    }

    public void createBall() {
        final Sprite ballSprite = new Sprite(atlas.findRegion("ball"));
        final Body ballBody = rubeSceneHelper.getBody("ball");
        final Entity ballEntity = new Entity();
        ballEntity.add(new SpriteComponent(ballSprite));
        ballEntity.add(new BodyComponent(ballBody));
        final PositionComponent positionComponent = new PositionComponent();
        ballEntity.add(positionComponent);
        ballEntity.add(new CameraFollowerComponent(camera, SCENE_BOUNDS));
        ballSprite.setScale(2 / ballSprite.getHeight());
        engine.addEntity(ballEntity);
    }

    public void createTeams() {
        final Sprite panda = new Sprite(atlas.findRegion("panda"));
        panda.setScale(ANIMAL_SPRITE_SCALE / panda.getHeight());
        final Array<PlayerEntity> tpanda = createPlayersOfTeam("panda", panda);
        addTeamToEngine(engine, tpanda);

        final Sprite monkey = new Sprite(atlas.findRegion("monkey"));
        monkey.setScale(ANIMAL_SPRITE_SCALE / monkey.getHeight());
        final Array<PlayerEntity> tmonkey = createPlayersOfTeam("monkey", monkey);
        addTeamToEngine(engine, tmonkey);
    }

    public void createSystems() {
        UnprojectInputSystem unprojectInputSystem = new UnprojectInputSystem();
        SelectPlayerByTouchSystem selectPlayerByTouchSystem = new SelectPlayerByTouchSystem();
        AISystem aiSystem = new AISystem();
        MetersToPixelConvertSystem metersToPixelConvertSystem = new MetersToPixelConvertSystem(PIXEL_TO_METER_FACTOR);
        CameraPositionSystem cameraPositionSystem = new CameraPositionSystem();
        RenderSystem renderSystem = new RenderSystem(viewport, DEBUG_PHYSICS);
        ContactSystem contactSystem = new ContactSystem();
        WorldStepSystem worldStepSystem = new WorldStepSystem();

        engine.addSystem(unprojectInputSystem);
        engine.addSystem(selectPlayerByTouchSystem);
        engine.addSystem(aiSystem);
        engine.addSystem(metersToPixelConvertSystem);
        engine.addSystem(cameraPositionSystem);
        engine.addSystem(renderSystem);
        //engine.addSystem(contactSystem);
        engine.addSystem(worldStepSystem);
    }

    private void createWorld() {
        Entity worldEntity = new Entity();
        worldEntity.add(new WorldComponent(rubeSceneHelper.getWorld()));
        engine.addEntity(worldEntity);
    }

    private void addTeamToEngine(Engine engine, Array<PlayerEntity> players) {
        for (PlayerEntity p : players) {
            engine.addEntity(p);
        }
    }

    public Array<PlayerEntity> createPlayersOfTeam(String teamName, Sprite uniform) {
        Team team = new Team(teamName);
        Array<PlayerEntity> players = new Array<PlayerEntity>();
        for (int i = 0; i < 11; i++) {
            final PlayerEntity player = createPlayer(team, uniform, "player" + i, i + 1);
            players.add(player);
        }
        return players;
    }

    private PlayerEntity createPlayer(Team team, Sprite uniform, String playerName, int n) {
        final Body playerBodyModel = rubeSceneHelper.getBody("player");
        PlayerEntity.Builder builder = PlayerEntity.newBuilder().name(playerName).number(n);
        builder.addComponent(new SpriteComponent(uniform));
        builder.addComponent(new PositionComponent());
        final PlayerEntity player = builder.build();
        final Body body = BodyBuilder.clone(playerBodyModel).build();
        body.setUserData(PlayerUserData.getFor(player));
        player.add(new BodyComponent(body));
        player.add(new MatchContextComponent(team, PlayerPosition.ATTACKER));
        return player;
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
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }

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
        System.out.println("touchDown");
        touchDownInputComponent.set(screenX, screenY, pointer, button);
        return true;
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
