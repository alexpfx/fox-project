package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.games.race.entities.fonts.DefaultFont;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by alexandre on 05/05/15.
 */
public class HudStage extends Stage {

    private Camera camera;

    public HudStage() {
        super(800f, 480f);
    }

    @Override
    public void init() {
        addVisual(new DefaultFont(new ResourceManager(new DefaultStageAssetConfig())));
    }





}
