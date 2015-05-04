package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.lang.reflect.Field;
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

    public Entity attachDrawable(Entity entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field f : fields) {
            DrawableName drawableName = f.getAnnotation(DrawableName.class);
            if (drawableName == null) {
                continue;
            }
            attachDrawable(entity, f, drawableName, resourceManager);
        }
        return entity;
    }

    private void attachDrawable(Entity entity, Field f, DrawableName drawableName, ResourceManager resourceManager) {
        TextureRegion region = resourceManager.getRegion(drawableName.atlasName(), drawableName.drawableName());
        try {
            f.setAccessible(true);
            VisualEntity ve = (VisualEntity) f.get(entity);
            ve.setDrawable(ImageDrawable.createFromTextureRegion(region));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

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


