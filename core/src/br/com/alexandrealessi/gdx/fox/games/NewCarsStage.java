package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.entities.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.Stage;
import br.com.alexandrealessi.gdx.fox.base.physic.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.constants.ResolutionConstants;
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
        bodyBuilder.build(peugeot);
        setWorldRenderer(new WorldRenderer(rubeSceneWrapper.getWorld(), ResolutionConstants.WORLD.value));
    }



}
