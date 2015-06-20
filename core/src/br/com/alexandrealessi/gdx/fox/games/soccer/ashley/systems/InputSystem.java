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
import com.badlogic.gdx.math.MathUtils;

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
        float y = controller.getAxis(XboxOneMapping.AXIS_LEFT_Y) *  -1;
        x = Math.abs(x) > 0.05f?x:0;
        y = Math.abs(y) > 0.05f?y:0;
        boolean b = controller.getButton(XboxOneMapping.BUTTON_A);
        System.out.println(b);

        float MULT = 50;
        System.out.println();
        System.out.println(x);
        System.out.println(y);
        final Entity player = players.get(14);
        final BodyComponent bodyComponent = ComponentMappers.BODY.get(player);


//        bodyComponent.getBody().applyForceToCenter(x * MULT, y * MULT, true);
        if (b){
            bodyComponent.getBody().setLinearVelocity(x* MULT, y * MULT);
        }

    }
}
