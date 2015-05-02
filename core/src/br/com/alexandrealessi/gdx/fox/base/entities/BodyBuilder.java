package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.utils.wrappers.RubeSceneWrapper;
import br.com.alexandrealessi.gdx.fox.games.Peugeot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;

import java.lang.reflect.InvocationTargetException;
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
            PhysicalEntity pe = null;
            if (m.isAnnotationPresent(BodyName.class)){
                try {
                    m.setAccessible(true);
                    pe = (PhysicalEntity) m.invoke(entity, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                BodyName bodyName = m.getAnnotation(BodyName.class);
                String s = bodyName.bodyNameReference();
                Body body = rubeSceneWrapper.getBody(s);
                pe.setBodyWrapper(new BodyWrapper(body));
            }
        }
    }
}