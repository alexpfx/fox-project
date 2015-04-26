package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.IBaseItem;
import com.uwsoft.editor.renderer.physics.PhysicsBodyLoader;
import com.uwsoft.editor.renderer.resources.ResourceManager;

import java.util.ArrayList;

/**
 * Created by alexandre on 24/04/15.
 */
public class OverlapExampleStage extends Overlap2DStage {


    private ResourceManager resourceManager;
    private World world;


    public OverlapExampleStage(ResourceManager resourceManager) {
        super();
        this.resourceManager = resourceManager;
        initSceneLoader(resourceManager);
        sceneLoader.loadScene("car");

        addActor(sceneLoader.getRoot());

        final CompositeItem carComposite = sceneLoader.getRoot().getCompositeById("car");

        RubeSceneLoader rubeSceneLoader = new RubeSceneLoader();
        RubeScene scene = rubeSceneLoader.loadScene(Gdx.files.internal("pug.json"));

        world = scene.getWorld();






        final CarController carController = new CarController();
        carComposite.addScript(carController);
        carController.init(carComposite);

        Body chassiBody = scene.getNamed(Body.class, "chassi").get(0);
        Body rodadianteira = scene.getNamed(Body.class, "rodaDianteira").get(0);
        Body rodatraseira = scene.getNamed(Body.class, "rodaTraseira").get(0);
        Body chao = scene.getNamed(Body.class, "chao").get(0);

        carComposite.getItemById("chassi").setBody(chassiBody);
        carComposite.getItemById("rodaDianteira").setBody(rodadianteira);
        carComposite.getItemById("rodaTraseira").setBody(rodatraseira);


    }

    @Override
    public World getWorld() {
        return world;
    }
}
