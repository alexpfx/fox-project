package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.box2d.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.base.screens.BaseScreen;
import br.com.alexandrealessi.gdx.fox.base.utils.StopWatch;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.BallFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.FieldFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.GoalLineFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.InputFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems.*;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends BaseScreen implements GestureDetector.GestureListener {
    //1248 x 794
    //1700 x 1150

    public static final int PIXEL_TO_METER_FACTOR = 1;
    public static final boolean DEBUG_PHYSICS = true;
    public static final float CAMERA_ZOOM = 0.6f;
    public static final String DATA_IMAGES_GAME_ATLAS = "data/images/game.atlas";
    public static final String SOCCER_JSON = "soccer.json";
    private static final float SCENE_WIDTH = 178f;
    private static final float SCENE_HEIGHT = 120;
    private static final float ANIMAL_SPRITE_SCALE = 7F;
    private static final Rectangle SCENE_BOUNDS = new Rectangle(-SCENE_WIDTH, -SCENE_HEIGHT, SCENE_WIDTH, SCENE_HEIGHT);
    boolean isDrag = false;
    Array<Vector2> points = new Array<Vector2>();
    private TouchDownInputComponent touchDownInputComponent;
    private Engine engine;
    private TextureAtlas atlas;
    private RubeSceneHelper rubeSceneHelper;
    private OrthographicCamera camera;
    private Viewport viewport;
    private GestureDetector gestureDetector;
    private Team homeTeam;
    private Team awayTeam;

    public GamePlayScreen(SoccerGame game) {
        super(game);
        engine = new Engine();
        setupViewport();
        setupInput();
        createResourceHelperObjects();
        createWorld();
        createField();
        createBall();
        createGoalLines();
        createTeams();
        createMatch();
        createSystems();
    }

    private void createMatch() {
        Entity match = new Entity();
        match.add(new MatchScoreComponent(homeTeam, awayTeam));
    }

    private void setupInput() {
        this.touchDownInputComponent = new TouchDownInputComponent();
        InputFactory.getInstance(viewport, touchDownInputComponent).createAndAddToEngine(engine);
        Gdx.input.setInputProcessor(new GestureDetector(this));
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

    public void createGoalLines(){
        final GoalLineFactory factory = GoalLineFactory.getInstance(rubeSceneHelper);

        factory.setTeam(awayTeam);
        factory.createAndAddToEngine(engine);

        factory.setTeam(homeTeam);
        factory.createAndAddToEngine(engine);
    }

    public void createField() {
        FieldFactory.newInstance(rubeSceneHelper, atlas, SCENE_HEIGHT).createAndAddToEngine(engine);
    }

    public void createBall() {
        BallFactory.getInstance(atlas, rubeSceneHelper, camera, SCENE_BOUNDS).createAndAddToEngine(engine);
    }

    public void createTeams() {
        homeTeam = new Team("Gremio", true);
        final Sprite panda = new Sprite(atlas.findRegion("panda"));
        panda.setScale(ANIMAL_SPRITE_SCALE / panda.getHeight());
        final Array<PlayerEntity> tpanda = createPlayersOfTeam(panda, homeTeam);
        addTeamToEngine(engine, tpanda);

        awayTeam = new Team("Internacional", false);
        final Sprite monkey = new Sprite(atlas.findRegion("monkey"));
        monkey.setScale(ANIMAL_SPRITE_SCALE / monkey.getHeight());
        final Array<PlayerEntity> tmonkey = createPlayersOfTeam(monkey, awayTeam);
        addTeamToEngine(engine, tmonkey);
    }

    public void createSystems() {
        UnprojectInputSystem unprojectInputSystem = new UnprojectInputSystem();
        SelectPlayerByTouchSystem selectPlayerByTouchSystem = new SelectPlayerByTouchSystem();
        AISystem aiSystem = new AISystem();
        MetersToPixelConvertSystem metersToPixelConvertSystem = new MetersToPixelConvertSystem(PIXEL_TO_METER_FACTOR);
        CameraPositionSystem cameraPositionSystem = new CameraPositionSystem();
        RenderSystem renderSystem = new RenderSystem(viewport, DEBUG_PHYSICS);
        WorldStepSystem worldStepSystem = new WorldStepSystem();

        engine.addSystem(unprojectInputSystem);
        engine.addSystem(selectPlayerByTouchSystem);
        engine.addSystem(aiSystem);
        engine.addSystem(metersToPixelConvertSystem);
        engine.addSystem(cameraPositionSystem);
        engine.addSystem(renderSystem);
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

    public Array<PlayerEntity> createPlayersOfTeam(Sprite uniform, Team team) {
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
        final Sprite sprite = new Sprite(uniform);
        builder.addComponent(new SpriteComponent(sprite));
        builder.addComponent(new PositionComponent());
        final PlayerEntity player = builder.build();
        final Body body = BodyBuilder.clone(playerBodyModel).build();
        body.setUserData(PlayerUserData.getFor(player));
        player.add(new BodyComponent(body));
        player.add(new PlayerMatchContextComponent(team, PlayerPosition.ATTACKER));
        return player;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        StopWatch.start(); // tempo de um ciclo (game loop)
        StopWatch.startNanos();
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);
        final long n = StopWatch.elapsedNanos();
        final float s = StopWatch.elapsedSeconds();
//        System.out.println("nanos: " + n);
//        System.out.println("segundos: " + s);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }

    //Input

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        touchDownInputComponent.set(x, y, pointer, button);
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

} // 271 -> 100
