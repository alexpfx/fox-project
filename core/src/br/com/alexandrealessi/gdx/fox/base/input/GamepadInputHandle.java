package br.com.alexandrealessi.gdx.fox.base.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

import static br.com.alexandrealessi.gdx.fox.base.input.XboxOneMapping.*;

/**
 * Created by alexandre on 14/06/15.
 */
public class GamepadInputHandle extends ControllerAdapter {

    private InputHandleListener inputHandleListener;

    public GamepadInputHandle(InputHandleListener inputHandleListener) {
        this.inputHandleListener = inputHandleListener;
    }

    @Override
    public void connected(Controller controller) {
        System.out.println(controller.getName());
    }

    @Override
    public void disconnected(Controller controller) {
        System.out.println(controller.getName());
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        switch (buttonCode) {
            case BUTTON_A:
                inputHandleListener.pressA();
                break;
            case BUTTON_B:
                inputHandleListener.pressB();
                break;
            case BUTTON_X:
                inputHandleListener.pressX();
                break;
            case BUTTON_Y:
                inputHandleListener.pressY();
                break;
        }
        return true;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {

        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        switch (axisCode) {
            case AXIS_LEFT_X:
                inputHandleListener.leftAxisX(axisCode, value);
                break;
            case AXIS_LEFT_Y:
                inputHandleListener.leftAxisY(axisCode, value);
                break;
            case AXIS_RIGHT_X:
                inputHandleListener.rightAxisX(axisCode, value);
                break;
            case AXIS_RIGHT_Y:
                inputHandleListener.rightAxisY(axisCode, value);
                break;
        }

        return true;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection povDirection) {
        switch (povDirection){
            case center:
                break;
            case north:
                inputHandleListener.povUp();
                break;
            case south:
                inputHandleListener.povDown();
                break;
            case east:
                inputHandleListener.povRight();
                break;
            case west:
                inputHandleListener.povLeft();
                break;
            case northEast:
                break;
            case southEast:
                break;
            case northWest:
                break;
            case southWest:
                break;
        }
        return true;

    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {

        return false;
    }

    public interface InputHandleListener {
        void pressA();

        void pressB();

        void pressX();

        void pressY();

        void leftAxisX(int code, float value);

        void leftAxisY(int code, float value);

        void rightAxisX(int code, float value);

        void rightAxisY(int code, float value);

        void povUp ();

        void povDown ();

        void povLeft ();

        void povRight ();

    }

}
