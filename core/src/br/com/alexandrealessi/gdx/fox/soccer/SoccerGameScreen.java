package br.com.alexandrealessi.gdx.fox.soccer;

import br.com.alexandrealessi.gdx.fox.base.BaseGameOld;
import br.com.alexandrealessi.gdx.fox.base.BaseScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by alexandre on 21/04/15.
 */
public class SoccerGameScreen extends BaseScreen {
    private final String tag = SoccerGameScreen.class.getName();

    int x = 0;

    public SoccerGameScreen(BaseGameOld game) {
        super(game);
        setColor(Color.GREEN);
        Gdx.app.log(tag, "create");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (x++ % 1000 == 0) {
            Gdx.app.log(tag, "render");
        }
    }
}
