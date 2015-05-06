package br.com.alexandrealessi.gdx.fox.games.race.entities.fonts;

import br.com.alexandrealessi.gdx.fox.base.entities.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.FontDrawable;
import br.com.alexandrealessi.gdx.fox.base.entities.VisualEntity;
import br.com.alexandrealessi.gdx.fox.base.resources.ResourceManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.annotation.Resource;

/**
 * Created by alexandre on 05/05/15.
 */
public class DefaultFont implements VisualEntity{


    //TODO: ta muito bagunçado. refatorarar geral.
    private Drawable drawable;

    public DefaultFont (ResourceManager resourceManager){
        resourceManager.load();
        drawable =  new FontDrawable(resourceManager.getFont(), 400,400);
    }


    @Override
    public void draw(SpriteBatch batch, float alpha) {
        drawable.draw(batch, alpha, Vector2.Zero.add(0, 0), 5);

    }

    @Override //TODO: nao precisa. considerar criar uma classe pai abstrata para estes drawables.
    public void setDrawable(Drawable drawable) {


    }

    @Override
    public void dispose() {

    }
}
