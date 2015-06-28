package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.FieldEntity;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/06/15.
 */
public class FieldEntityFactory {

    public static final String FIELD = "field";
    private RubeSceneHelper rubeSceneHelper;
    private TextureAtlas atlas;

    public FieldEntityFactory(RubeSceneHelper rubeSceneHelper, TextureAtlas atlas) {
        this.rubeSceneHelper = rubeSceneHelper;
        this.atlas = atlas;
    }

    public FieldEntity create(String imageName, float scaleFactor) {
        final Body body = rubeSceneHelper.getBody(FIELD);
        final Sprite sprite = new Sprite(atlas.findRegion(imageName));
        FieldEntity fieldEntity = new FieldEntity(body, ScaledSprite.createUsingHeight(sprite, scaleFactor));
        return fieldEntity;
    }

}
