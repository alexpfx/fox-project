package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by alex on 01/05/2015.
 */

public class NewCarsGame extends BaseGame {


    private Stage stage;
    public NewCarsGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        stage = new NewCarsStage(800, 480);
        stage.init();
    }

    @Override
    public void render() {
        clear(Color.DARK_GRAY);
        stage.render();
    }
}
