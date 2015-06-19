package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.ControllersComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

/**
 * Created by alexandre on 19/06/15.
 */
public class ControllersHolderFactory extends CreateAndAddToEngineEntityFactory {

    public static final String CONTROLLER = "controller";

    @Override
    public Entity create(CreateArguments arguments) {
        Controller controller = arguments.get(CONTROLLER);
        Entity entity = new Entity();
        entity.add(ControllersComponent.newInstance(controller));
        return entity;
    }
}
