package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SteerComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class PhysicToScreenSystem extends EntitySystem {

    private final float worldToScreen;
    private ImmutableArray<Entity> entities;
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<SteerComponent> sm = ComponentMapper.getFor(SteerComponent.class);

    public PhysicToScreenSystem(float worldToScreen) {
        this.worldToScreen = worldToScreen;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(SteerComponent.class, PositionComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {

        for (int i = 0; i < entities.size(); i++) {
            final Entity e = entities.get(i);
            final SteerComponent steerComponent = sm.get(e);
            final PositionComponent positionComponent = pm.get(e);
            final Body body = steerComponent.getBody();
            float x = body.getPosition().x * worldToScreen;
            float y = body.getPosition().y * worldToScreen;
            float r = body.getAngle() * MathUtils.radDeg;
            positionComponent.setPosition(x, y, r);
        }
    }
}
