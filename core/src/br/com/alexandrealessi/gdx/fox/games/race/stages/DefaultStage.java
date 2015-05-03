package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.PhysicBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.DrawableBuilder;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Peugeot;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.ResolutionConstants;

/**
 * Created by alex on 02/05/2015.
 */
public class DefaultStage extends Stage{


    public DefaultStage(float width, float height) {
        super(width, height);
    }

    public void init (){
        Peugeot peugeot = new Peugeot();
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper("carscene.json", null);
        PhysicBuilder physicBuilder = new PhysicBuilder(rubeSceneWrapper);
        DrawableBuilder drawableBuilder = new DrawableBuilder(new ResourceManager(new DefaultStageAssetConfig()));
        physicBuilder.build(peugeot);
        drawableBuilder.buildImageDrawable(peugeot);
        setWorldRenderer(new WorldRenderer(rubeSceneWrapper.getWorld(), ResolutionConstants.WORLD.value));

        addEntity(peugeot);
        addEntity(peugeot.getChassis());
        addEntity(peugeot.getFrontWheel());
        addEntity(peugeot.getRearWheel());


    }



}
