package br.com.alexandrealessi.gdx.fox.games.race;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.GameStatusListener;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenUtils;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.PlayableStage;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.race.stages.DefaultPlayableStage;
import br.com.alexandrealessi.gdx.fox.games.race.stages.DefaultStageAssetConfig;
import br.com.alexandrealessi.gdx.fox.games.race.stages.HudStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by alex on 01/05/2015.
 */

public class RaceGame extends BaseGame {


    private GameStatusListener statusListener;
    private GameStatusListener.GameStatus statusChanger;
    private GameStatusListener.GameStatus status;

    private PlayableStage playableStage;
    HudStage hudStage;

    public RaceGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        ResourceManager rm = new ResourceManager(new DefaultStageAssetConfig());
        rm.load();
        playableStage = new DefaultPlayableStage(rm);
        playableStage.init();
        hudStage = new HudStage(rm);
        hudStage.init();
        statusListener = hudStage;
        statusChanger = (DefaultPlayableStage) playableStage;
        Gdx.input.setInputProcessor(playableStage);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.DARK_GRAY);
        playableStage.render();
        hudStage.render();
        statusListener.statusChange(statusChanger);
    }

}
