package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.InputHandle;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 15/06/15.
 */
public class GameInputControlsComponent extends Component implements InputHandle.InputHandleListener {

    private boolean buttonA;
    private boolean buttonB;
    private boolean buttonX;
    private boolean buttonY;

    public boolean isButtonA() {
        return buttonA;
    }

    public void setButtonA(boolean buttonA) {
        this.buttonA = buttonA;
    }

    public boolean isButtonB() {
        return buttonB;
    }

    public void setButtonB(boolean buttonB) {
        this.buttonB = buttonB;
    }

    public boolean isButtonX() {
        return buttonX;
    }

    public void setButtonX(boolean buttonX) {
        this.buttonX = buttonX;
    }

    public boolean isButtonY() {
        return buttonY;
    }

    public void setButtonY(boolean buttonY) {
        this.buttonY = buttonY;
    }

    @Override
    public void pressA() {
        buttonA = true;
    }

    @Override
    public void pressB() {
        buttonB = true;
    }

    @Override
    public void pressX() {
        buttonX = true;
    }

    @Override
    public void pressY() {
        buttonY = true;
    }
}
