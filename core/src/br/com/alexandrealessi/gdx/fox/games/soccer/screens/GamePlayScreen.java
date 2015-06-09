package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.base.screens.BaseScreen;
import br.com.alexandrealessi.gdx.fox.base.utils.EmptyObjects;
import br.com.alexandrealessi.gdx.fox.base.utils.StopWatch;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerPosition;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.*;
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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends BaseScreen implements GestureDetector.GestureListener {

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
        createTeams();
        createBall();
        createGoalLines();
        createMatch();
        createSystems();
    }

    private void createMatch() {
        MatchFactory.newInstance(45f, homeTeam, awayTeam)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
    }

    private void setupInput() {
        this.touchDownInputComponent = new TouchDownInputComponent();
        InputFactory.getInstance(viewport, touchDownInputComponent)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
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

    //FIXME: so esta computando um lado.
    public void createGoalLines() {
        final GoalLineFactory factory = GoalLineFactory.getInstance(rubeSceneHelper);

        CreateArguments arguments = new CreateArguments();
        arguments.put(GoalLineFactory.TEAM, awayTeam);
        arguments.put(GoalLineFactory.GOAL_LINE_BODY_NAME, "goal_line_right");
        factory.createAndAddToEngine(arguments, engine);

        arguments.put(GoalLineFactory.TEAM, homeTeam);
        arguments.put(GoalLineFactory.GOAL_LINE_BODY_NAME, "goal_line_left");
        factory.createAndAddToEngine(arguments, engine);
    }

    public void createField() {
        FieldFactory.newInstance(rubeSceneHelper, atlas, SCENE_HEIGHT)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
    }

    public void createBall() {
        BallFactory.getInstance(atlas, rubeSceneHelper, camera, SCENE_BOUNDS)
                   .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
    }

    public void createTeams() {
        homeTeam = new Team("Gremio", true);
        final Sprite panda = new Sprite(atlas.findRegion("panda"));
        final Array<Entity> tpanda = createPlayersOfTeam(ScaledSprite
                .newInstance(panda, ANIMAL_SPRITE_SCALE / panda.getHeight()), homeTeam);

        awayTeam = new Team("Internacional", false);
        final Sprite monkey = new Sprite(atlas.findRegion("monkey"));
        final Array<Entity> tmonkey = createPlayersOfTeam(ScaledSprite
                .newInstance(monkey, ANIMAL_SPRITE_SCALE / monkey.getHeight()), awayTeam);
    }

    public void createSystems() {
        UnprojectInputSystem unprojectInputSystem = new UnprojectInputSystem();
        SelectPlayerByTouchSystem selectPlayerByTouchSystem = new SelectPlayerByTouchSystem();
        AISystem aiSystem = new AISystem();
        MetersToPixelConvertSystem metersToPixelConvertSystem = new MetersToPixelConvertSystem(PIXEL_TO_METER_FACTOR);
        CameraPositionSystem cameraPositionSystem = new CameraPositionSystem();
        RenderSystem renderSystem = new RenderSystem(viewport, DEBUG_PHYSICS);
        WorldStepSystem worldStepSystem = new WorldStepSystem();
        GameManagmentSystem gameManagmentSystem = new GameManagmentSystem();

        engine.addSystem(unprojectInputSystem);
        engine.addSystem(selectPlayerByTouchSystem);
        engine.addSystem(aiSystem);
        engine.addSystem(metersToPixelConvertSystem);
        engine.addSystem(cameraPositionSystem);
        engine.addSystem(renderSystem);
        engine.addSystem(worldStepSystem);
        engine.addSystem(gameManagmentSystem);
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

    public Array<Entity> createPlayersOfTeam(ScaledSprite uniform, Team team) {
        Array<Entity> players = new Array<Entity>();
        for (int i = 0; i < 11; i++) {
            final Entity player = createPlayer(team, uniform, "player" + i, i + 1);
            players.add(player);
        }
        return players;
    }

    private Entity createPlayer(Team team, ScaledSprite uniform, String playerName, int n) {

        CreateArguments arguments = new CreateArguments();
        arguments.put(PlayerFactory.PLAYER_POSITION, PlayerPosition.ATTACKER);
        arguments.put(PlayerFactory.PLAYER_NAME, playerName);
        arguments.put(PlayerFactory.UNIFORM, uniform);
        arguments.put(PlayerFactory.TEAM, team);
        arguments.put(PlayerFactory.PLAYER_NUMBER, n);

        final Entity player = PlayerFactory.newInstance(rubeSceneHelper)
                                           .createAndAddToEngine(arguments, engine);

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
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }

    //Input //TODO: mover para outra classe.
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

} // 271/244 -> 100 -> 249
