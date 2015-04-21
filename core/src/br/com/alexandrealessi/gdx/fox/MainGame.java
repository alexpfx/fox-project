package br.com.alexandrealessi.gdx.fox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    RequestHandler requestHandler;

    /**
     * Construtor usado quando nao se pretende usar servico de LeaderboardsInterface
     */
    public MainGame() {
        this(RequestHandler.NULL);
    }

    public MainGame(RequestHandler requestHand) {
        this.requestHandler = requestHand;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

    }

    int x = 0;

    @Override
    public void render() {
        if ((++x  % 1000) == 0){ //TESTE
            requestHandler.submitScore(GameServicesKeys.LEADERBOARD_BEST_FOXES.key, 10);
        }
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

}
