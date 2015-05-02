package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alexandre on 02/05/15.
 */
public class DrawableBuilder {
    private ResourceManager resourceManager;

    public DrawableBuilder(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public void buildImageDrawable(VisualEntity entity) {
        for (Method method : entity.getClass().getDeclaredMethods()) {
            if (!method.isAnnotationPresent(DrawableName.class)) {
                continue;
            }
            final DrawableName drawableName = method.getAnnotation(DrawableName.class);
            VisualEntity ve = null;
            try {
                method.setAccessible(true);
                ve = (VisualEntity) method.invoke(entity, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            final TextureRegion texture = resourceManager.getRegion(drawableName.atlasName(), drawableName.drawableName());
            ve.setDrawable(ImageDrawable.createFromTextureRegion(texture));
        }
    }
}


