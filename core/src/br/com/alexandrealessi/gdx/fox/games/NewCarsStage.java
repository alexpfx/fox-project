package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.entities.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.base.entities.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;

/**
 * Created by alex on 02/05/2015.
 */
public class NewCarsStage extends Stage{

    public NewCarsStage(float width, float height) {
        super(width, height);
    }

    public void init (){
        Peugeot peugeot = new Peugeot();
        BodyBuilder bodyBuilder = new BodyBuilder(new RubeSceneWrapper("carscene.json", null));
        bodyBuilder.build(peugeot);
    }




}
