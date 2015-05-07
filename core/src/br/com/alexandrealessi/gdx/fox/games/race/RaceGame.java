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
    private Stage hudStage;
    public RaceGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        stage = new DefaultStage();
        stage.init();
        hudStage.init();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.DARK_GRAY);
        stage.render();
        hudStage.render();
    }

    @Override
    public void resize(int width, int height) {
        stage.resize(width, height);
    }
}
