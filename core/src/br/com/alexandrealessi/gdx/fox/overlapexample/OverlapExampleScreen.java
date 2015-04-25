package br.com.alexandrealessi.gdx.fox.overlapexample;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.BaseScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by alexandre on 25/04/15.
 */
public class OverlapExampleScreen extends BaseScreen {
    private OverlapExampleStage stage;

    public OverlapExampleScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        ResourceManager resourceManager = new ResourceManager();
        resourceManager.initAllResources();

        stage = new OverlapExampleStage(resourceManager);
        final Array<Actor> actors = stage.getActors();
        for (Actor actor:actors){
            final String name = actor.getName();
            Gdx.app.log(OverlapExampleScreen.class.getName(), name);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        stage.draw();
    }



}
