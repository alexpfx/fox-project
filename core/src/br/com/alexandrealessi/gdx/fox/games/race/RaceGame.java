package br.com.alexandrealessi.gdx.fox.games.race;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.ScreenUtils;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import br.com.alexandrealessi.gdx.fox.games.race.stages.DefaultStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by alex on 01/05/2015.
 */

public class RaceGame extends BaseGame {


    private Stage stage;
    public RaceGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        stage = new DefaultStage(800, 480);
        stage.init();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.DARK_GRAY);
        stage.render();
    }
}
