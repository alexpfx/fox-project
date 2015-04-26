package br.com.alexandrealessi.gdx.fox.overlapexample;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.BaseGame2;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import br.com.alexandrealessi.gdx.fox.base.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by alexandre on 23/04/15.
 */
public class OverlapExampleGame extends BaseGame2 {

    private InputMultiplexer inputMultiplexer;
    private WorldRenderer worldRenderer;
    private OverlapExampleStage gameStage;

    public OverlapExampleGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        ResourceManager resourceManager = new ResourceManager();
        inputMultiplexer = new InputMultiplexer();
        resourceManager.initAllResources();
        gameStage = new OverlapExampleStage(resourceManager);
        worldRenderer = new WorldRenderer(gameStage.getWorld(),800 / (31.5f), 480 / (31.5f ));
        inputMultiplexer.addProcessor(gameStage);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render() {
        clear(Color.BLACK);
        gameStage.act();
        gameStage.draw();
        worldRenderer.render();
    }

    protected void clear(Color bgColor) {
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }



}
