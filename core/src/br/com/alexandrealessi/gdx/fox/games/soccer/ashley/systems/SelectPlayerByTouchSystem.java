package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchContextComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerEntity;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import br.com.alexandrealessi.gdx.fox.games.soccer.input.Touch;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

/**
 * Created by alexandre on 31/05/15.
 * <p/>
 * Sistema para selecionar o player mais proximo do evento de Touch lancado pelo usuario.
 */
public class SelectPlayerByTouchSystem extends EntitySystem {

    Entity touch;
    ImmutableArray<Entity> players;

    @Override
    public void addedToEngine(Engine engine) {
        touch = engine.getEntitiesFor(Family.all(TouchDownInputComponent.class).get()).first();
        players = engine.getEntitiesFor(Family.all(MatchContextComponent.class, PositionComponent.class, SpriteComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {

        final TouchDownInputComponent touchDownInputComponent = ComponentMappers.TOUCH_DOWN_INPUT.get(touch);
        if (!touchDownInputComponent.isConsumed()) {
            final Touch touch = touchDownInputComponent.getTouch();
            int x = 0;
            for (Entity e : players) {
                System.out.println(x++);
                MatchContextComponent matchContext = ComponentMappers.MATCH_CONTEXT.get(e);
                if (matchContext.getTeam().isUserTeam()){
                    continue;
                }

                final PositionComponent position = ComponentMappers.POSITION.get(e);


            }
        }

    }
}
