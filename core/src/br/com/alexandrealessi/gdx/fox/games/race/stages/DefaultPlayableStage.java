package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.GameStatusListener;
import br.com.alexandrealessi.gdx.fox.base.entities.PhysicObject;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.base.entities.SpriteDrawable;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.PlayableStage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Car;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Chassis;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Wheel;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import net.dermetfan.gdx.physics.box2d.Chain;
import org.omg.CORBA.TRANSACTION_MODE;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.UP;

/**
 * Created by alex on 02/05/2015.
 */
public class DefaultPlayableStage extends PlayableStage implements GameStatusListener.GameStatus {


    private static final float amount = 50f;
    private static final float DIRECTION_RIGHT = -1;
    private static final float DIRECTION_LEFT = 1;
    public static final String GAME_ATLAS = "game.atlas";
//    public static final String PEUGEOT_CHASSIS = "peugeot_chassis";
//    public static final String PEUGEOT_FRONT_WHEEL = "peugeot_front_wheel";
//    public static final String PEUGEOT_REAR_WHEEL = "peugeot_rear_wheel";
    public static final String PEUGEOT_CHASSIS = "rodao_chassis";
    public static final String PEUGEOT_FRONT_WHEEL = "rodao_front_wheel";
    public static final String PEUGEOT_REAR_WHEEL = "rodao_rear_wheel";

    private Car peugeot;
    private PhysicObject rCar;
    private ResourceManager resourceManager;
    private RubeSceneWrapper rubeSceneWrapper;
    private Map gameStatus;

    public DefaultPlayableStage(ResourceManager resourceManager) {
        super(new ThisStageScreenContext(), new ThisStageWorldContext());
        this.resourceManager = resourceManager;
    }

    public void init() {
        itializeWorld();
        createGameObjects();
        gameStatus = new Map();
    }

    private void itializeWorld() {
        rubeSceneWrapper = new RubeSceneWrapper("carscene.json", null);
        final WorldRenderer worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), getWorldContext());
        setWorldRenderer(worldRenderer);
    }

    public void createSome (){
        final World world = rubeSceneWrapper.getWorld();
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.position.set(0, 0);
        Body body = world.createBody(bd);

        ChainShape chainShape = new ChainShape();
        EdgeShape edgeShape = new EdgeShape();

        edgeShape.setHasVertex0(false);
        edgeShape.setHasVertex3(false);
        edgeShape.setVertex0(-1, 1);
        edgeShape.set(-20, 2, 3, 30);
        edgeShape.setVertex3(50, 5);


        body.createFixture(edgeShape, 1);
    /* fill dataSet with path points */

//        body.createFixture(chainShape, .1f);
//        chainShape.dispose();


    }

    Vector2 newVector (float x, float y){
        return new Vector2(x, y);
    }


    private void createGameObjects() {
        final Body peugeot_chassis = rubeSceneWrapper.getBody(PEUGEOT_CHASSIS);
        final Body peugeot_front_wheel = rubeSceneWrapper.getBody(PEUGEOT_FRONT_WHEEL);
        final Body peugeot_rear_wheel = rubeSceneWrapper.getBody(PEUGEOT_REAR_WHEEL);

//        SpriteDrawable imgChassis = new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, PEUGEOT_CHASSIS)), screenContext);
//        SpriteDrawable imgFrontWheel = new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, PEUGEOT_FRONT_WHEEL)), screenContext);
//        SpriteDrawable imgRearWheel = new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, PEUGEOT_REAR_WHEEL)), screenContext);

//        final Chassis chassis = new Chassis(new RigidBody(peugeot_chassis, worldContext), imgChassis);
//        final Wheel rear = new Wheel(new RigidBody(peugeot_rear_wheel, worldContext), imgFrontWheel);
//        final Wheel front = new Wheel(new RigidBody(peugeot_front_wheel, worldContext), imgRearWheel);


        final Chassis chassis = new Chassis(new RigidBody(peugeot_chassis, worldContext));
        final Wheel rear = new Wheel(new RigidBody(peugeot_rear_wheel, worldContext));
        final Wheel front = new Wheel(new RigidBody(peugeot_front_wheel, worldContext));


        peugeot = new Car(chassis, front, rear);
        addEntity(chassis);
        addEntity(front);
        addEntity(rear);
        pointCameraTo(chassis);

    }



    @Override
    public void handleInput() {
        if (isJustPressed(UP)) {
            accelerateCar(amount, DIRECTION_RIGHT,1);
        }

        if (isJustPressed(DOWN)) {
            accelerateCar(amount, DIRECTION_LEFT,1);
        }
        if (isTouch()) {
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2) {
                accelerateCar(amount, DIRECTION_RIGHT, Gdx.input.getY());
            } else {
                accelerateCar(amount, DIRECTION_LEFT, Gdx.input.getY());
            }
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        createSome();
        return true;
    }

    private boolean isJustPressed(int key) {
        return Gdx.input.isKeyPressed(key);
    }

    private boolean isTouch() {
        return Gdx.input.isTouched();
    }

    public void accelerateCar(float amount, float direction, float y) {
//        final float height = Gdx.graphics.getHeight();
//        float ratio = 100 / height;
//        final float acc = amount * (ratio * (height - y));
        peugeot.accelerate(amount, direction);

    }

    @Override
    public Map getStatus() {
        return gameStatus;
    }

    private static class ThisStageScreenContext implements WorldContext {
        @Override
        public float getWidth() {
            return Size.SCREEN.width();
        }

        @Override
        public float getHeight() {
            return Size.SCREEN.height();
        }
    }

    private static class ThisStageWorldContext implements WorldContext {
        @Override
        public float getWidth() {
            return Size.WORLD.width();
        }

        @Override
        public float getHeight() {
            return Size.WORLD.height();
        }
    }

    @Override
    protected void afterUpdate() {
        gameStatus.getProperties().put("kmh", peugeot.getKmh ());

    }
}
