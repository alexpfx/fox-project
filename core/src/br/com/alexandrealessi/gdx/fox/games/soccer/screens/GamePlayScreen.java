package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.base.input.GamepadInputHandle;
import br.com.alexandrealessi.gdx.fox.base.screens.BaseScreen;
import br.com.alexandrealessi.gdx.fox.base.utils.EmptyObjects;
import br.com.alexandrealessi.gdx.fox.base.utils.StopWatch;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.GameInputControlsComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.BallEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.TeamFormation;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends BaseScreen {

    public static final int PIXEL_TO_METER_FACTOR = 1;
    public static final boolean DEBUG_PHYSICS = true;
    public static final float CAMERA_ZOOM = 0.6f;
    public static final String DATA_IMAGES_GAME_ATLAS = "data/images/game.atlas";
    public static final String SOCCER_JSON = "soccer.json";
    private static final float SCENE_WIDTH = 178f;
    private static final float SCENE_HEIGHT = 120;
    private static final float ANIMAL_SPRITE_SCALE = 3.5F;
    private static final Rectangle SCENE_BOUNDS = new Rectangle(-SCENE_WIDTH, -SCENE_HEIGHT, SCENE_WIDTH, SCENE_HEIGHT);
    private TouchDownInputComponent touchDownInputComponent;
    private Engine engine;
    private TextureAtlas atlas;
    private RubeSceneHelper rubeSceneHelper;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Entity homeTeam;
    private Entity awayTeam;

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
        MatchFactory.create(45f, homeTeam, awayTeam)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
    }

    private void setupInput() {
        ControllersHolderFactory controllersHolderFactory = new ControllersHolderFactory();
        CreateArguments arguments = new CreateArguments();
        arguments.put(ControllersHolderFactory.CONTROLLERS, Controllers.getControllers());
        controllersHolderFactory.createAndAddToEngine(arguments, engine);

        this.touchDownInputComponent = new TouchDownInputComponent();

        final GameInputControlsComponent gameInputControlsComponent = new GameInputControlsComponent();
        GamepadInputHandle inputHandle = new GamepadInputHandle(gameInputControlsComponent);
        Controllers.addListener(inputHandle);

        InputFactory.create(viewport, touchDownInputComponent, gameInputControlsComponent)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);

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

    public void createGoalLines() {
        final GoalLineFactory factory = GoalLineFactory.create(rubeSceneHelper);

        CreateArguments arguments = new CreateArguments();
        arguments.put(GoalLineFactory.TEAM, awayTeam);
        arguments.put(GoalLineFactory.GOAL_LINE_BODY_NAME, "goal_line_right");
        factory.createAndAddToEngine(arguments, engine);

        arguments.put(GoalLineFactory.TEAM, homeTeam);
        arguments.put(GoalLineFactory.GOAL_LINE_BODY_NAME, "goal_line_left");
        factory.createAndAddToEngine(arguments, engine);
    }

    public void createField() {
        FieldFactory.create(rubeSceneHelper, atlas, SCENE_HEIGHT)
                    .createAndAddToEngine(EmptyObjects.EMPTY_CREATE_ARGUMENTS, engine);
    }

    public void createBall() {
        final BallEntity ballEntity = new BallEntityFactory(atlas, rubeSceneHelper)
                .createBallEntity("ball", 0.78f, camera);
        engine.addEntity(ballEntity.getEntity());
    }

    public void createTeams() {
        TeamFactory factory = TeamFactory.create(11, rubeSceneHelper);

        final Sprite panda = new Sprite(atlas.findRegion("giraffe"));
        final ScaledSprite gremioUniform = ScaledSprite
                .create(panda, ANIMAL_SPRITE_SCALE / panda.getHeight());

        homeTeam = createTeam(factory, TeamFormation.F433, gremioUniform, "Gremio", TeamSide.RIGHT, true);

        final Sprite elephant = new Sprite(atlas.findRegion("snake"));
        final ScaledSprite interUniform = ScaledSprite
                .create(elephant, ANIMAL_SPRITE_SCALE / elephant.getHeight());

        awayTeam = createTeam(factory, TeamFormation.F442, interUniform, "Inter", TeamSide.LEFT, false);
    }

    private Entity createTeam(TeamFactory factory, TeamFormation teamFormation, ScaledSprite mainUniform, String name, TeamSide side, boolean userTeam) {
        CreateArguments arguments = new CreateArguments();
        arguments.put(TeamFactory.TEAM_FORMATION, teamFormation);
        arguments.put(TeamFactory.TEAM_MAIN_UNIFORM, mainUniform);
        arguments.put(TeamFactory.TEAM_NAME, name);
        arguments.put(TeamFactory.TEAM_SIDE, side);
        arguments.put(TeamFactory.TEAM_IS_USER_TEAM, userTeam);
        return factory.createAndAddToEngine(arguments, engine);
    }

    public void createSystems() {
        engine.addSystem(new TeamCreationSystem(rubeSceneHelper));
        engine.addSystem(new TeamResetSystem());
        engine.addSystem(new UnprojectInputSystem());
        //        engine.addSystem(new SelectPlayerByTouchSystem());
        engine.addSystem(new InputSystem());
        engine.addSystem(new AISystem());
        engine.addSystem(new MetersToPixelConvertSystem(PIXEL_TO_METER_FACTOR));
        engine.addSystem(new CameraPositionSystem());
        engine.addSystem(new RenderSystem(viewport, DEBUG_PHYSICS));
        engine.addSystem(new WorldStepSystem());
        engine.addSystem(new GameManagmentSystem());
    }

    private void createWorld() {
        Entity worldEntity = new Entity();
        worldEntity.add(new WorldComponent(rubeSceneHelper.getWorld()));
        engine.addEntity(worldEntity);
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

} // 213 -> 100 -> 226 220 201
