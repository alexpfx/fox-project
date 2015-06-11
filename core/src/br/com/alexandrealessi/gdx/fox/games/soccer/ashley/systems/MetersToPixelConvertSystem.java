package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.EntityUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class MetersToPixelConvertSystem extends EntitySystem {
    //TODO: transformar em iterable system

    private final float pixelToMeterFactor;
    private ImmutableArray<Entity> entities;

    public MetersToPixelConvertSystem(float pixelToMeterFactor) {
        this.pixelToMeterFactor = pixelToMeterFactor;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(BodyComponent.class, PositionComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); i++) {
            final Entity e = entities.get(i);
            final BodyComponent bodyComponent = ComponentMappers.BODY.get(e);
            final EntityUserData userData = (EntityUserData)  bodyComponent.getBody().getUserData();
            if (userData != null){


            }
            final PositionComponent positionComponent = ComponentMappers.POSITION.get(e);
            final Body body = bodyComponent.getBody();
            float x = body.getPosition().x * pixelToMeterFactor;
            float y = body.getPosition().y * pixelToMeterFactor;
            float r = body.getAngle() * MathUtils.radDeg;
            positionComponent.setPosition(x, y, r);
        }
    }
}
