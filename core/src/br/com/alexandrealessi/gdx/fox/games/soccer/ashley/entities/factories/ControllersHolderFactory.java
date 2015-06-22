package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.ControllersComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 19/06/15.
 */
public class ControllersHolderFactory extends CreateAndAddToEngineEntityFactory {

    public static final String CONTROLLERS = "controller";

    @Override
    public Entity create(CreateArguments arguments) {

        Array<Controller> controller = arguments.get(CONTROLLERS);
        Entity entity = new Entity();

        for (Controller c : controller) {
            entity.add(ControllersComponent.newInstance(c));
        }
        return entity;
    }
}
