package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.SpriteComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by alexandre on 07/06/15.
 */
public class FieldFactory extends CreateAndAddToEngineEntityFactory {
    private static final String FIELD_BODY_NAME = "field";
    private RubeSceneHelper rubeSceneHelper;
    private TextureAtlas atlas;
    private float SCENE_HEIGHT;

    private FieldFactory(RubeSceneHelper rubeSceneHelper, TextureAtlas atlas, float SCENE_HEIGHT) {
        this.rubeSceneHelper = rubeSceneHelper;
        this.atlas = atlas;
        this.SCENE_HEIGHT = SCENE_HEIGHT;
    }

    public static FieldFactory create(RubeSceneHelper rubeSceneHelper, TextureAtlas atlas, float SCENE_HEIGHT) {
        return new FieldFactory(rubeSceneHelper, atlas, SCENE_HEIGHT);
    }

    @Override
    public Entity create(CreateArguments arguments) {
        Entity field = new Entity();

        field.add(BodyComponent.newInstance(rubeSceneHelper.getBody(FIELD_BODY_NAME)));
        field.add(PositionComponent.newInstance());

        final Sprite soccer = new Sprite(atlas.findRegion("small_field"));
        soccer.setScale(SCENE_HEIGHT / soccer.getHeight());
        field.add(SpriteComponent.newInstance(soccer));

        return field;
    }
}
