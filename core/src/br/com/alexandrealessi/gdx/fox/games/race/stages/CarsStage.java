package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.physic.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.components.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.games.CarsGameConstants;
import br.com.alexandrealessi.gdx.fox.games.race.domain.VehicleFactory;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.loader.RubeSceneLoader;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsStage extends Stage {

    private final WorldRenderer worldRenderer;
    public static final String RUBE_SCENE_FILE = "carscene.json";
    public static final String ATLAS_NAME = "game_atlas";
    private final CompositeActor car;
    private ResourceManager resourceManager;

    public CarsStage(Vector2 viewPort) {
        super(new StretchViewport(viewPort.x, viewPort.y));
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper(new RubeSceneLoader().loadScene(Gdx.files.internal(RUBE_SCENE_FILE)));
        resourceManager = new ResourceManager(new CarsGameStageAssetConfig());
        resourceManager.load();
        VehicleFactory manufacture = new VehicleFactory(rubeSceneWrapper, resourceManager);
        car = manufacture.createCar();
        worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), CarsGameConstants.Sizes.WORLD.value);
        addActor(car);
    }

    @Override
    public void act() {
        super.act();

    }

    @Override
    public void draw() {
        super.draw();
        worldRenderer.render();
    }

    private TextureRegion getRegion(String regioName) {
        return resourceManager.getRegion(ATLAS_NAME, regioName);
    }

}
