package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.controllers.Controller;

/**
 * Created by alexandre on 19/06/15.
 */
public class ControllersComponent extends Component{

    private Controller controller;

    private ControllersComponent(Controller controller) {
        this.controller = controller;
    }

    public static ControllersComponent newInstance(Controller controller) {
        return new ControllersComponent(controller);
    }
}
