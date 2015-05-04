package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.entities.DrawableBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.PhysicBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import br.com.alexandrealessi.gdx.fox.base.stages.Stage;
import br.com.alexandrealessi.gdx.fox.base.stages.WorldRenderer;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Car;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.Size;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.UP;

/**
 * Created by alex on 02/05/2015.
 */
public class DefaultStage extends Stage {

    private static final float DEFAULT_AMOUNT = 0.3f;
    private static final float DIRECTION_RIGHT = -1;
    private static final float DIRECTION_LEFT = 1;
    private Car peugeot;
    public DefaultStage(float width, float height) {
        super(width, height);
    }

    public void init (){
        peugeot = new Car();
        final RubeSceneWrapper rubeSceneWrapper = new RubeSceneWrapper("carscene.json", null);
        PhysicBuilder physicBuilder = new PhysicBuilder(rubeSceneWrapper);
        DrawableBuilder drawableBuilder = new DrawableBuilder(new ResourceManager(new DefaultStageAssetConfig()));
        physicBuilder.attachBody(peugeot);

        drawableBuilder.attachDrawable(peugeot);
        final WorldRenderer worldRenderer = new WorldRenderer(rubeSceneWrapper.getWorld(), new Vector2(Size.WORLD.scale(Size.ASPECT_RATIO.value()), Size.WORLD.value()));
        setWorldRenderer(worldRenderer);
//        worldRenderer.setCamera((OrthographicCamera) getViewPort().getCamera());



        //nao precisa adicionar no mundo se nao tem representacao (body). nem precisaria ser DefaultEntity.
//        addEntity(peugeot);
        addEntity(peugeot.getChassis());
        addEntity(peugeot.getFrontWheel());
        addEntity(peugeot.getRearWheel());
    }

    @Override
    public void render() {
        doInput();
        super.render();
    }

    private void doInput() {
        if (isJustPressed(UP)){
            accelerateCar(DEFAULT_AMOUNT, DIRECTION_RIGHT);

        }
        if (isJustPressed(DOWN)){
            accelerateCar(DEFAULT_AMOUNT, DIRECTION_LEFT);
        }
    }

    private boolean isJustPressed (int key){
        return Gdx.input.isKeyPressed(key);
    }


    public void accelerateCar (float amount , float direction){
        peugeot.accelerate(amount, direction);
    }

}
