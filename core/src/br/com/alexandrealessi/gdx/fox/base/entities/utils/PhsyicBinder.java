package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.entities.Entity;
import br.com.alexandrealessi.gdx.fox.base.entities.PhysicalEntity;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Axis;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alex on 02/05/2015.
 */
public class PhsyicBinder {

    private final RubeSceneWrapper rubeSceneWrapper;

    public PhsyicBinder(RubeSceneWrapper rubeSceneWrapper) {
        this.rubeSceneWrapper = rubeSceneWrapper;
    }

    public Entity attachBody(Entity entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field f : fields) {
            BodyName annotation = f.getAnnotation(BodyName.class);
            if (annotation == null) {
                continue;
            }
            attachBody(entity, f, annotation, rubeSceneWrapper);
        }
        return entity;
    }

    private void attachBody(Entity entity, Field f, BodyName bodyName, RubeSceneWrapper rubeSceneWrapper) {
        Body body = rubeSceneWrapper.getBody(bodyName.bodyNameReference());
        f.setAccessible(true);
        try {
            PhysicalEntity ph = (PhysicalEntity) f.get(entity);
            ph.setBody(body);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public void attachJoint(PhysicalEntity entity, Method m, JointName jointName) {
        final Joint joint = rubeSceneWrapper.getJoint(jointName.jointName());
        try {
            m.invoke(entity, new Axis(joint));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}