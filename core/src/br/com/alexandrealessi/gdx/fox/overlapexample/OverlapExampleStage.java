package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by alexandre on 24/04/15.
 */
public class OverlapExampleStage extends Stage {

    private final CarController carController;
    private ResourceManager resourceManager;
    private World world;

    public OverlapExampleStage(ResourceManager resourceManager) {
        super(new StretchViewport(800, 480));
        this.resourceManager = resourceManager;

        Actor actor = new Actor();
        addActor(actor);

        RubeSceneLoader rubeSceneLoader = new RubeSceneLoader();
        RubeScene scene = rubeSceneLoader.loadScene(Gdx.files.internal("pug.json"));
        final Array<RubeImage> imgChassi = scene.getNamed(RubeImage.class, "imgChassi");
        actor.setUserObject(imgChassi);

        world = scene.getWorld();


        carController = new CarController();

        Body chassiBody = scene.getNamed(Body.class, "chassi").get(0);
        Body rodadianteira = scene.getNamed(Body.class, "rodaDianteira").get(0);
        Body rodatraseira = scene.getNamed(Body.class, "rodaTraseira").get(0);
        Body chao = scene.getNamed(Body.class, "chao").get(0);

    }

    @Override
    public void act() {
        super.act();
        if (Gdx.input.isTouched()){
            dedalPress(Gdx.input.getX());
        }

    }

    public World getWorld() {
        return world;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        return true;
    }



    private boolean dedalPress(int screenX) {
        System.out.println("dedal");
        if (screenX < getWidth() / 2f) {
            carController.desaccelarete();
        } else {
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
