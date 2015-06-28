package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.ScaledSprite;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 26/06/15.
 */
public class FieldEntity extends UserEntity {

    private Body fieldBody;
    private ScaledSprite fieldSprite;

    public FieldEntity(Body fieldBody, ScaledSprite fieldSprite) {
        super(true);
        this.fieldBody = fieldBody;
        this.fieldSprite = fieldSprite;
    }

    protected FieldEntity() {
        super(false);
    }

    @Override
    protected Component[] getComponents() {
        return new Component[]{
                BodyComponent.newInstance(fieldBody),
                PositionComponent.newInstance(),
                SpriteComponent.newInstance(fieldSprite.getSprite())
        };
    }

    @Override
    protected Family getDistinctFamily() {
        return Family.one(BodyComponent.class).get();
    }
}
