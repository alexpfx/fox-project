package br.com.alexandrealessi.gdx.fox.saturn;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by alexandre on 24/04/15.
 */
public class OverlapExampleStage extends Overlap2DStage {

    private ResourceManager resourceManager;

    public OverlapExampleStage(ResourceManager resourceManager) {
        super();
        this.resourceManager = resourceManager;
        initSceneLoader(resourceManager);
        sceneLoader.loadScene("MainScene");
        addActor(sceneLoader.getRoot());
        PlayerController player = new PlayerController();
        sceneLoader.getRoot().getCompositeById("player").addScript(player);

    }
}
