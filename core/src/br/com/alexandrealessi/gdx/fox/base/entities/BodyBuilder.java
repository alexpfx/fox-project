package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.Peugeot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;

import java.lang.reflect.Method;

/**
 * Created by alex on 02/05/2015.
 */
public class BodyBuilder {

    private final RubeSceneWrapper rubeSceneWrapper;

    public BodyBuilder(RubeSceneWrapper rubeSceneWrapper) {
        this.rubeSceneWrapper = rubeSceneWrapper;
    }

    public void build (PhysicalEntity entity){
        Method[] declaredMethods = entity.getClass().getDeclaredMethods();
        for (Method m:declaredMethods){
            if (m.isAnnotationPresent(BodyName.class)){
                BodyName bodyName = m.getAnnotation(BodyName.class);
                String s = bodyName.bodyNameReference();
                Body body = rubeSceneWrapper.getBody(s);
                entity.setBodyWrapper(new BodyWrapper(body));
            }
        }
    }


}
