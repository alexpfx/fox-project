package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.entities.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.DrawableBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.Stage;
import br.com.alexandrealessi.gdx.fox.base.physic.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.constants.ResolutionConstants;
import br.com.alexandrealessi.gdx.fox.games.race.stages.CarsGameStageAssetConfig;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by alex on 02/05/2015.
 */
public class NewCarsStage extends Stage{


    public NewCarsStage(float width, float height) {
        super(width, height);
    }

    public void init (){
        Peugeot peugeot = new Peugeot();
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper("carscene.json", null);
        BodyBuilder bodyBuilder = new BodyBuilder(rubeSceneWrapper);
        DrawableBuilder drawableBuilder = new DrawableBuilder(new ResourceManager(new CarsGameStageAssetConfig()));
        bodyBuilder.build(peugeot);
        drawableBuilder.buildImageDrawable(peugeot);
        setWorldRenderer(new WorldRenderer(rubeSceneWrapper.getWorld(), ResolutionConstants.WORLD.value));

        addEntity(peugeot);
        addEntity(peugeot.getChassis());
        addEntity(peugeot.getFrontWheel());
        addEntity(peugeot.getRearWheel());


    }



}
