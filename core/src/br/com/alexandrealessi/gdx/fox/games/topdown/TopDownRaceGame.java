package br.com.alexandrealessi.gdx.fox.games.topdown;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenUtils;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.topdown.stages.DefaultAssetConfig;
import br.com.alexandrealessi.gdx.fox.games.topdown.stages.GameStage;

import static com.badlogic.gdx.graphics.Color.BLACK;

/**
 * Created by alexandre on 16/05/15.
 */
public class TopDownRaceGame extends BaseGame {
    private GameStage gameStage;

    public TopDownRaceGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        ResourceManager rm = new ResourceManager(new DefaultAssetConfig());
        rm.load();
        gameStage = new GameStage();
        gameStage.init();

    }

    @Override
    public void render() {
        ScreenUtils.clear(BLACK);
        gameStage.render();
    }
}
