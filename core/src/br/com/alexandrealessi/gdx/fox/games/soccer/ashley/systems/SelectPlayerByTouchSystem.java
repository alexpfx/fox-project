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

        final Entity player = players.get(15);

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

    public Entity getAndSetSelectedNearestPlayer(float x, float y) {
        float lowDistance = Float.MAX_VALUE;
        Entity nearest = null;
        for (Entity e : players) {
            if (nearest == null) {
                nearest = e;
            }
            PlayerMatchContextComponent matchContext = ComponentMappers.PLAYER_MATCH_CONTEXT.get(e);
            final Entity team = matchContext.getTeam();
            final TeamMatchContextComponent teamMatchContextComponent = ComponentMappers.TEAM_MATCH_CONTEXT.get(team);
            if (teamMatchContextComponent.isUserTeam()) {
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
