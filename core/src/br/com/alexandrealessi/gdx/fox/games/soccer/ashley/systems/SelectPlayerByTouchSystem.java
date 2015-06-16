package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.input.Touch;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 31/05/15.
 * <p/>
 * Sistema para selecionar o player mais proximo do evento de Touch lancado pelo usuario.
 */
public class SelectPlayerByTouchSystem extends EntitySystem {

    Entity input;
    ImmutableArray<Entity> players;

    @Override
    public void addedToEngine(Engine engine) {
        input = engine.getEntitiesFor(Family.one(TouchDownInputComponent.class, GameInputControlsComponent.class).get())
                      .first();
        players = engine
                .getEntitiesFor(Family
                        .all(PlayerMatchContextComponent.class, PositionComponent.class, SpriteComponent.class)
                        .get());
    }

    @Override
    public void update(float deltaTime) {
        final GameInputControlsComponent gameInputControlsComponent = ComponentMappers.GAME_INPUT_CONTROLS.get(input);
        final TouchDownInputComponent touchDownInputComponent = ComponentMappers.TOUCH_DOWN_INPUT.get(input);

        final Entity player = players.get(MathUtils.random(players.size() - 1));
        processar(player, gameInputControlsComponent);

        if (!touchDownInputComponent.isConsumed()) {
            final Touch touch = touchDownInputComponent.getTouch();
            int x = 0;
            Entity nearest = getAndSetSelectedNearestPlayer(touch.x, touch.y);
            final PlayerMatchContextComponent playerMatchContextComponent = ComponentMappers.PLAYER_MATCH_CONTEXT
                    .get(nearest);
            playerMatchContextComponent.setIsSelected(true);
            final SpriteComponent spriteComponent = ComponentMappers.SPRITE_COMPONENT.get(nearest);
            spriteComponent.getSprite().setColor(Color.WHITE);
        }
    }

    private void processar(Entity player, GameInputControlsComponent gameInputControlsComponent) {
        final boolean buttonX = gameInputControlsComponent.isButtonX();
        final BodyComponent bodyComponent = ComponentMappers.BODY.get(player);
        final float impulse = 5 * 10000;
        if (buttonX) {
            bodyComponent.getBody().applyForceToCenter(-impulse * 1f, 0, true);

            System.out.println("x");
        }
        final boolean buttonY = gameInputControlsComponent.isButtonY();
        if (buttonY) {
            bodyComponent.getBody().applyForceToCenter(0, impulse, true);
        }

        final boolean buttonA = gameInputControlsComponent.isButtonA();
        if (buttonA) {
            bodyComponent.getBody().applyForceToCenter(0, -impulse, true);
        }
        final boolean buttonB = gameInputControlsComponent.isButtonB();
        if (buttonB) {
            bodyComponent.getBody().applyForceToCenter(impulse, 0, true);
        }

        gameInputControlsComponent.reset();
    }

    public Entity getAndSetSelectedNearestPlayer(float x, float y) {
        float lowDistance = Float.MAX_VALUE;
        Entity nearest = null;
        for (Entity e : players) {
            if (nearest == null) {
                nearest = e;
            }
            PlayerMatchContextComponent matchContext = ComponentMappers.PLAYER_MATCH_CONTEXT.get(e);
            final Entity team = matchContext.getTeam();
            final TeamMatchContext teamMatchContext = ComponentMappers.TEAM_MATCH.get(team);
            if (teamMatchContext.isUserTeam()) {
                continue;
            }

            matchContext.setIsSelected(false);

            final Vector2 position = ComponentMappers.POSITION.get(e).getPosition();
            final float dist = position.dst2(x, y);
            if (dist < lowDistance) {
                lowDistance = dist;
                nearest = e;
            }
        }
        return nearest;
    }

}
