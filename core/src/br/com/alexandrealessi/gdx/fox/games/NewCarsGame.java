package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.MovableEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxNativesLoader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
