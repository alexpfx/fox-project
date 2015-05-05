package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.lang.reflect.Field;

/**
 * Created by alexandre on 02/05/15.
 */
public class DrawableBinder {
    private ResourceManager resourceManager;

    public DrawableBinder(ResourceManager resourceManager) {
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
}


