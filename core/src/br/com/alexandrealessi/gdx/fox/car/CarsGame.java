package br.com.alexandrealessi.gdx.fox.car;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import br.com.alexandrealessi.gdx.fox.car.stages.CarsGameStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsGame extends BaseGame {

    CarsGameStage stage;

    public CarsGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void create() {
        stage = new CarsGameStage(CarGameConstants.Sizes.SCREEN.value());
    }

    @Override
    public void render() {
        clear(Color.BLACK);
        stage.act();
        stage.draw();
    }

    protected void clear(Color bgColor) {
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
