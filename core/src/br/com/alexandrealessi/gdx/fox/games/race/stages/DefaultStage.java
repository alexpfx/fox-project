package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.PhysicObject;
import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.base.entities.SpriteDrawable;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenContext;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Car;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Chassis;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Wheel;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.UP;

/**
 * Created by alex on 02/05/2015.
 */
public class DefaultStage extends Stage {

    private static final float DEFAULT_AMOUNT = 0.45f;
    private static final float DIRECTION_RIGHT = -1;
    private static final float DIRECTION_LEFT = 1;
    public static final String GAME_ATLAS = "game.atlas";
    private Car peugeot;
    private PhysicObject rCar;
    private ResourceManager resourceManager;
    private RubeSceneWrapper rubeSceneWrapper;

    public DefaultStage() {
        super(new ThisStageScreenContext(), new ThisStageWorldContext());
    }

    public void init() {
        createResourceManager();
        createGameObjects();
    }

    private void createResourceManager() {
        resourceManager = new ResourceManager(new DefaultStageAssetConfig());
        rubeSceneWrapper = new RubeSceneWrapper("carscene.json", null);
        final WorldRenderer worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), new Vector2(Size.WORLD.width(), Size.WORLD.height()));
        setWorldRenderer(worldRenderer);
    }

    private void createGameObjects() {
        final Body peugeot_chassis = rubeSceneWrapper.getBody("peugeot_chassis");
        final Body peugeot_front_wheel = rubeSceneWrapper.getBody("peugeot_front_wheel");
        final Body peugeot_rear_wheel = rubeSceneWrapper.getBody("peugeot_rear_wheel");

        new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, "peugeot_chassis")), screenContext);
        new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, "peugeot_front_wheel")), screenContext);
        new SpriteDrawable(new Sprite(resourceManager.getRegion(GAME_ATLAS, "peugeot_rear_wheel")), screenContext);

        final Chassis chassis = new Chassis(new RigidBody(peugeot_chassis, worldContext));
        final Wheel rear = new Wheel(new RigidBody(peugeot_rear_wheel, worldContext));
        final Wheel front = new Wheel(new RigidBody(peugeot_front_wheel, worldContext));

        peugeot = new Car(chassis, front, rear);
    }

    @Override
    public void handleInput() {
        if (isJustPressed(UP)) {
            accelerateCar(DEFAULT_AMOUNT, DIRECTION_RIGHT);

        }
        if (isJustPressed(DOWN)) {
            accelerateCar(DEFAULT_AMOUNT, DIRECTION_LEFT);
        }
        if (isTouch()) {
            System.out.println(Gdx.input.getX());
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2) {
                accelerateCar(DEFAULT_AMOUNT, DIRECTION_RIGHT);
            } else {
                accelerateCar(DEFAULT_AMOUNT, DIRECTION_LEFT);
            }
        }
    }

    private boolean isJustPressed(int key) {
        return Gdx.input.isKeyPressed(key);
    }

    private boolean isTouch() {
        return Gdx.input.isTouched();
    }

    public void accelerateCar(float amount, float direction) {
        peugeot.accelerate(amount, direction);
    }

    private static class ThisStageScreenContext implements ScreenContext {
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
}
