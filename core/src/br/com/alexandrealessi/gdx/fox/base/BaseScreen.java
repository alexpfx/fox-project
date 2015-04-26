package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 21/04/15.
 */
public abstract class BaseScreen extends ScreenAdapter {

    protected BaseGameOld game;
    protected SpriteBatch batch;
    private Color color = Color.BLACK;


    public BaseScreen(BaseGameOld game) {
        this.game = game;
        batch = new SpriteBatch();

    }

    @Override
    public void render(float delta) {
        clear();
    }

    protected void clear() {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
