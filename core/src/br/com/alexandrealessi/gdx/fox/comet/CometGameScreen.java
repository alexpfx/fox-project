package br.com.alexandrealessi.gdx.fox.comet;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.BaseScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by alexandre on 21/04/15.
 */
public class CometGameScreen extends BaseScreen {
    private final String tag = CometGameScreen.class.getName();

    public CometGameScreen(BaseGame game) {
        super(game);
        setColor(Color.BLUE);
        Gdx.app.log(tag, "constructor");
    }

    int x = 0;


    @Override
    public void render(float delta) {
        super.render(delta);
        if (x++ % 1000 == 0) {
            Gdx.app.log(tag, "render");
        }
    }
}
