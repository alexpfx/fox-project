package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.DrawableBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.PhysicBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Car;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.ResolutionConstants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by alex on 02/05/2015.
 */
public class DefaultStage extends Stage{


    private Car peugeot;
    public DefaultStage(float width, float height) {
        super(width, height);
    }

    public void init (){
        peugeot = new Car();
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

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.UP){
            peugeot.accelerate(-10, -100);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP){
            peugeot.brek(0);
        }
        return true;
    }
}
