package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by alexandre on 24/04/15.
 */
public class OverlapExampleStage extends Overlap2DStage {

    private final CarController carController;
    private ResourceManager resourceManager;
    private World world;

    public OverlapExampleStage(ResourceManager resourceManager) {
        super(new StretchViewport(800, 480));
        this.resourceManager = resourceManager;
        initSceneLoader(resourceManager);
        sceneLoader.loadScene("car");

        addActor(sceneLoader.getRoot());

        final CompositeItem carComposite = sceneLoader.getRoot().getCompositeById("car");

        RubeSceneLoader rubeSceneLoader = new RubeSceneLoader();
        RubeScene scene = rubeSceneLoader.loadScene(Gdx.files.internal("pug.json"));

        world = scene.getWorld();

        carController = new CarController();




        Body chassiBody = scene.getNamed(Body.class, "chassi").get(0);
        Body rodadianteira = scene.getNamed(Body.class, "rodaDianteira").get(0);
        Body rodatraseira = scene.getNamed(Body.class, "rodaTraseira").get(0);
        Body chao = scene.getNamed(Body.class, "chao").get(0);

        carComposite.getItemById("chassi").setBody(chassiBody);
        carComposite.getItemById("rodaDianteira").setBody(rodadianteira);
        carComposite.getItemById("rodaTraseira").setBody(rodatraseira);

        carComposite.addScript(carController);

    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        if (screenX < getWidth() / 2f) {
            carController.desaccelarete();
        }else{
            carController.accelerate();
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        carController.stop();
        return true;
    }
}
