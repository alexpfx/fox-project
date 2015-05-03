package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.entities.PhysicalEntity;
import br.com.alexandrealessi.gdx.fox.games.race.entities.cars.Axis;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointEdge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alex on 02/05/2015.
 */
public class PhysicBuilder {

    private final RubeSceneWrapper rubeSceneWrapper;

    public PhysicBuilder(RubeSceneWrapper rubeSceneWrapper) {
        this.rubeSceneWrapper = rubeSceneWrapper;
    }

    public void build (PhysicalEntity entity){
        Method[] declaredMethods = entity.getClass().getDeclaredMethods();
        for (Method m:declaredMethods){

            if (m.isAnnotationPresent(BodyName.class)){
                attachBody(entity, m, m.getAnnotation(BodyName.class));
            }
            if (m.isAnnotationPresent(JointName.class)){
                attachJoint (entity, m, m.getAnnotation(JointName.class));
            }
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

    private void attachBody(PhysicalEntity entity, Method m, BodyName bodyName) {
        PhysicalEntity pe = null;
        try {
//            m.setAccessible(true);
            pe = (PhysicalEntity) m.invoke(entity, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Body body = rubeSceneWrapper.getBody(bodyName.bodyNameReference());
        pe.setBodyWrapper(new BodyWrapper(body));
    }
}