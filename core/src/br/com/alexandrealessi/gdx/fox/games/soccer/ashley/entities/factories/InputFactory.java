package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.CameraComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.GameInputControlsComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 07/06/15.
 */
public class InputFactory extends CreateAndAddToEngineEntityFactory {
    private final GameInputControlsComponent gameInputControlsComponent;
    private Viewport viewport;
    private TouchDownInputComponent touchDownInputComponent;

    private InputFactory(Viewport viewport, TouchDownInputComponent touchDownInputComponent, GameInputControlsComponent gameInputControlsComponent) {
        this.viewport = viewport;
        this.touchDownInputComponent = touchDownInputComponent;
        this.gameInputControlsComponent = gameInputControlsComponent;
    }

    public static InputFactory newInstance(Viewport viewport, TouchDownInputComponent touchDownInputComponent, GameInputControlsComponent gameInputControlsComponent) {
        return new InputFactory(viewport, touchDownInputComponent, gameInputControlsComponent);
    }

    @Override
    public Entity create(CreateArguments arguments) {
        Entity input = new Entity();
        this.touchDownInputComponent = new TouchDownInputComponent();
        input.add(touchDownInputComponent);
        input.add(new CameraComponent(viewport.getCamera()));
        input.add(gameInputControlsComponent);
        return input;
    }
}
