package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class MetersToPixelConvertSystem extends EntitySystem {

    private final float pixelToMeterFactor;
    private ImmutableArray<Entity> entities;
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<BodyComponent> sm = ComponentMapper.getFor(BodyComponent.class);

    public MetersToPixelConvertSystem(float pixelToMeterFactor) {
        this.pixelToMeterFactor = pixelToMeterFactor;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(BodyComponent.class, PositionComponent.class).get());
        System.out.println(entities);
    }

    @Override
    public void update(float deltaTime) {

        for (int i = 0; i < entities.size(); i++) {
            final Entity e = entities.get(i);
            final BodyComponent bodyComponent = sm.get(e);
            final PositionComponent positionComponent = pm.get(e);
            final Body body = bodyComponent.getBody();
            float x = body.getPosition().x * pixelToMeterFactor;
            float y = body.getPosition().y * pixelToMeterFactor;
            float r = body.getAngle() * MathUtils.radDeg;
            positionComponent.setPosition(x, y, r);
        }
    }
}
