package br.com.alexandrealessi.gdx.fox.games.topdown.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;
import br.com.alexandrealessi.gdx.fox.base.entities.SpriteDrawable;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.PlayableStage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.games.topdown.entity.Track01;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alexandre on 16/05/15.
 */
public class GameStage extends PlayableStage {

    private final ResourceManager resourceManager;
    private static final String GAME_ATLAS = "topdown.atlas";
    private RubeSceneWrapper rubeSceneWrapper;

    public GameStage(ResourceManager resourceManager) {
        super(WorldContext.createNew(800, 480), WorldContext.createNew(80, 48));
        this.resourceManager = resourceManager;
    }

    @Override
    public void init() {
        rubeSceneWrapper = new RubeSceneWrapper("topdown.json");
        final TextureRegion path01 = resourceManager.getRegion(GAME_ATLAS, "path01");
        setWorldRenderer(new WorldRenderer(rubeSceneWrapper.getWorld(),getWorldContext()));
        Track01 t = new Track01(new RigidBody(rubeSceneWrapper.getBody("track"), getWorldContext()), new SpriteDrawable(new Sprite(path01), getScreenContext()));
        addEntity(t);

    }




}
