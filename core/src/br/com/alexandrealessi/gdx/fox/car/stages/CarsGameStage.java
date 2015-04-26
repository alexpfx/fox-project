package br.com.alexandrealessi.gdx.fox.car.stages;

import br.com.alexandrealessi.gdx.fox.base.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.actors.CompositeActor;
import br.com.alexandrealessi.gdx.fox.base.resources.AssetConfig;
import br.com.alexandrealessi.gdx.fox.base.resources.Assets;
import br.com.alexandrealessi.gdx.fox.car.CarGameConstants;
import br.com.alexandrealessi.gdx.fox.car.CarGameConstants.Strings;
import br.com.alexandrealessi.gdx.fox.car.actors.CarManufacture;
import br.com.alexandrealessi.gdx.fox.car.actors.RubeSceneWrapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.loader.RubeSceneLoader;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsGameStage extends Stage {

    private final WorldRenderer worldRenderer;
    public static final String RUBE_SCENE_FILE = "carscene.json";
    public static final String ATLAS_NAME = "game_atlas";
    private final CompositeActor car;
    private Assets assets;

    public CarsGameStage(Vector2 viewPort) {
        super(new StretchViewport(viewPort.x, viewPort.y));
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper(new RubeSceneLoader().loadScene(Gdx.files.internal(RUBE_SCENE_FILE)));
        assets = new Assets(carGameStageAssetConfig);
        assets.load();
        CarManufacture manufacture = new CarManufacture(rubeSceneWrapper, assets);
        car = manufacture.createCar();
        worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), CarGameConstants.Sizes.WORLD.value);
    }

    @Override
    public void act() {
        car.act(Gdx.graphics.getDeltaTime());
        car.draw(getBatch(), 0);
        worldRenderer.render();
    }

    private AssetConfig carGameStageAssetConfig = new AssetConfig() {
        @Override
        public String getAssetBaseDirectory() {
            return "car";
        }

        @Override
        public String[] getAtlasFiles() {
            return new String[]{Strings.GAME_ATLAS_NAME.value.concat(".atlas"), Strings.GUI_ATLAS_NAME.value.concat(".atlas")};
        }
    };

    private TextureRegion getRegion(String regioName) {
        return assets.getRegion(ATLAS_NAME, regioName);
    }

}
