package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.input.XboxOneMapping;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.controllers.Controller;

/**
 * Created by alexandre on 19/06/15.
 */
public class InputSystem extends EntitySystem {

    private Entity controller;
    private ImmutableArray<Entity> players;

    @Override
    public void addedToEngine(Engine engine) {
        controller = engine.getEntitiesFor(Family.all(ControllersComponent.class).get()).get(0);
        players = engine
                .getEntitiesFor(Family
                        .all(PlayerMatchContextComponent.class, PositionComponent.class, SpriteComponent.class)
                        .get());

    }

    @Override
    public void update(float deltaTime) {
        final ControllersComponent controllersComponent = ComponentMappers.CONTROLLERS.get(controller);
        final Controller controller = controllersComponent.getController();
        float x = controller.getAxis(XboxOneMapping.AXIS_LEFT_X);
        float y = controller.getAxis(XboxOneMapping.AXIS_LEFT_Y) * -1;
        x = Math.abs(x) > 0.05f ? x : 0;
        y = Math.abs(y) > 0.05f ? y : 0;
        boolean a = controller.getButton(XboxOneMapping.BUTTON_A);
        boolean b = controller.getButton(XboxOneMapping.BUTTON_B);
        boolean bx = controller.getButton(XboxOneMapping.BUTTON_X);
        boolean by = controller.getButton(XboxOneMapping.BUTTON_Y);

        System.out.println(a);

        float MULT = 20;
        final Entity player = players.get(14);
        final BodyComponent bodyComponent = ComponentMappers.BODY.get(player);

        if (a) {
            final float delta = 0.5f;
            bodyComponent.getBody().setLinearVelocity(x * MULT * delta, y * MULT * delta);
            System.out.println("xxx");
        } else if (b) {
            final float delta = 1f;
            bodyComponent.getBody().setLinearVelocity(x * MULT * delta, y * MULT * delta);
        } else if (bx) {
            final float delta = 2f;
            bodyComponent.getBody().setLinearVelocity(x * MULT * delta, y * MULT * delta);
        } else if (by) {
            final float delta = 4f;
            bodyComponent.getBody().setLinearVelocity(x * MULT * delta, y * MULT * delta);
        }
    }
}
