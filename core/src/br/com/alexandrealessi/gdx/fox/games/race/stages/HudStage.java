package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.CameraHolder;
import br.com.alexandrealessi.gdx.fox.base.entities.GameStatusListener;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 10/05/15.
 */
public class HudStage implements Stage, GameStatusListener{

    private final ResourceManager resourceManager;
    private BitmapFont font;
    private SpriteBatch batch;
    private CameraHolder camera;
    private String kmh = "";

    public HudStage (ResourceManager resourceManager){
        this.resourceManager = resourceManager;
    }

    @Override
    public void init() {
        font = resourceManager.getFont();
        batch = new SpriteBatch();
        camera = new CameraHolder(new OrthographicCamera(), 600, 600,1);
    }

    @Override
    public void render() {
        camera.setProjectionMatrix(batch);
        camera.update();
        batch.begin();
        font.setScale(.4f, .4f);
        font.draw(batch, "km/h: "+ kmh, -295, 295);
        batch.end();
    }

    @Override
    public void dispose() {

    }


    @Override
    public void statusChange(GameStatus status) {
        final String kmh = String.valueOf((Float) status.getStatus().getProperties().get("kmh"));
        this.kmh = kmh;
    }
}
