package br.com.alexandrealessi.gdx.fox.car.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsGameStage extends Stage {

    public static final String RUBE_SCENE_FILE = "pug.json";

    public CarsGameStage(Vector2 viewPort) {
        super(new StretchViewport(viewPort.x, viewPort.y));
    }

    private void loadScene() {
        RubeSceneLoader rubeSceneLoader = new RubeSceneLoader();
        final RubeScene scene = rubeSceneLoader.loadScene(Gdx.files.internal(RUBE_SCENE_FILE));
    }

    public void loadActors(RubeScene scene) {

    }

}
