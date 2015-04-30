package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.components.theather.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.physic.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.CarsGameConstants;
import br.com.alexandrealessi.gdx.fox.games.race.domain.refatorar.VehicleFactory;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.FactoryImpl;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.impl.Peugeot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.loader.RubeSceneLoader;

import static br.com.alexandrealessi.gdx.fox.games.CarsGameConstants.Sizes.*;

/**
 * Created by alexandre on 26/04/15.
 */
//Verificar a possibilidade de eliminar esta classe e criar uma mais simples.
public class CarsStage extends Stage {

    public static final String RUBE_SCENE_FILE = "carscene.json";
    public static final String ATLAS_NAME = "game_atlas";
    private final WorldRenderer worldRenderer;
    private final CompositeActor car;
    private ResourceManager resourceManager;

    public CarsStage(Vector2 viewPort) {
        super(new StretchViewport(viewPort.x, viewPort.y));
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper(new RubeSceneLoader().loadScene(Gdx.files.internal(RUBE_SCENE_FILE)));
        resourceManager = new ResourceManager(new CarsGameStageAssetConfig());
        resourceManager.load();
        VehicleFactory manufacture = new VehicleFactory(rubeSceneWrapper, resourceManager);
        worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), WORLD.getValue());

        Peugeot peugeot = Peugeot.createPeugeot();

        car = new FactoryImpl(rubeSceneWrapper, resourceManager).construct(peugeot);

    }

    @Override
    public void act() {
        car.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void draw() {
        getBatch().setProjectionMatrix(getCamera().combined);
        getBatch().begin();
        car.draw((SpriteBatch) getBatch(), 1f);
        getBatch().end();

        worldRenderer.render();

        final Vector2 worldPosition = car.getWorldPosition();
        final Vector2 positionOnScreen = TRANSFORM.value(worldPosition).from(WORLD).to(SCREEN);
        positionOnScreen.mulAdd(SCREEN.getValue(), .5f);
//        float x = WORLD.scaleX(worldPosition.x, SCREEN) + SCREEN.width() / 2;
//        float y = WORLD.scaleY(worldPosition.y, SCREEN) + SCREEN.height() / 2;

        float x = positionOnScreen.x;
        float y = positionOnScreen.y;

        worldRenderer.getCamera().position.set(worldPosition, 0);
        getCamera().position.set(x, y, 0);
        getCamera().update();

//        final float to = Prizes.transform(10).from(Prizes.WORLD).to(Prizes.SCREEN);
//
//        Prizes.DO.value(10).from(Prizes.WORLD).to(Prizes.SCREEN);

    }

    private TextureRegion getRegion(String regioName) {
        return resourceManager.getRegion(ATLAS_NAME, regioName);
    }

    public static void main(String[] args) {
        Vector2 result = CarsGameConstants.Sizes.TRANSFORM.value(new Vector2(5, 5)).from(CarsGameConstants.Sizes.WORLD).to(CarsGameConstants.Sizes.SCREEN);
        assertEquals(50f, result.x);
        assertEquals(50f, result.y);
        result = CarsGameConstants.Sizes.TRANSFORM.value(new Vector2(10, 20)).from(CarsGameConstants.Sizes.WORLD).to(CarsGameConstants.Sizes.SCREEN);
        assertEquals(100f, result.x);
        assertEquals(200f, result.y);
    }

    static void assertEquals(Float expected, Float actual) {
        if (expected.equals(actual)) {
            return;
        }
        throw new AssertionError("error");
    }

}
