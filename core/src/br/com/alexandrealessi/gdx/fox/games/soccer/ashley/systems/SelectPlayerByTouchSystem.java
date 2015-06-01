package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

/**
 * Created by alexandre on 31/05/15.
 *
 * Sistema para selecionar o player mais proximo do evento de Touch lancado pelo usuario.
 */
public class SelectPlayerByTouchSystem extends EntitySystem{

    Entity entity;
    @Override
    public void addedToEngine(Engine engine) {
        entity = engine.getEntitiesFor(Family.all(TouchDownInputComponent.class).get()).first();
    }

    @Override
    public void update(float deltaTime) {
        final TouchDownInputComponent touchDownInputComponent = ComponentMappers.TOUCH_DOWN_INPUT.get(entity);
        if (!touchDownInputComponent.isConsumed()){
            System.out.println(touchDownInputComponent.getTouch());
        }

    }
}
