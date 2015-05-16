package br.com.alexandrealessi.gdx.fox.games.topdown.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.WorldContext;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.PlayableStage;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.omg.CORBA.WCharSeqHelper;

/**
 * Created by alexandre on 16/05/15.
 */
public class GameStage extends PlayableStage {


    public GameStage(ResourceManager resourceManager) {
        super(WorldContext.createNew(800, 480), WorldContext.createNew(80, 48));
    }

    @Override
    public void init() {


    }


}
