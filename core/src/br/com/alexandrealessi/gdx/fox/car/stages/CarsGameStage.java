package br.com.alexandrealessi.gdx.fox.car.stages;

import br.com.alexandrealessi.gdx.fox.base.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.actors.CompositeActor;
import br.com.alexandrealessi.gdx.fox.car.SizeConstants;
import br.com.alexandrealessi.gdx.fox.car.actors.CarManufacture;
import br.com.alexandrealessi.gdx.fox.car.actors.RubeSceneWrapper;
import com.badlogic.gdx.Gdx;
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
    private final CompositeActor car;

    public CarsGameStage(Vector2 viewPort) {
        super(new StretchViewport(viewPort.x, viewPort.y));
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper(new RubeSceneLoader().loadScene(Gdx.files.internal(RUBE_SCENE_FILE)));
        CarManufacture manufacture = new CarManufacture(rubeSceneWrapper);
        car = manufacture.createCar();
        worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), SizeConstants.WORLD.size());
    }

    @Override
    public void act() {
        car.act(Gdx.graphics.getDeltaTime());
        car.draw(getBatch(), 0);
        worldRenderer.render();
    }
}
