package br.com.alexandrealessi.gdx.fox.base.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alexandre on 14/06/15.
 */
public class InputHandle extends ControllerAdapter {

    private InputHandleListener inputHandleListener;

    public InputHandle(InputHandleListener inputHandleListener) {
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
            case XboxOneMapping.BUTTON_A:
                inputHandleListener.pressA();
                break;
            case XboxOneMapping.BUTTON_B:
                inputHandleListener.pressB();
                break;
            case XboxOneMapping.BUTTON_X:
                inputHandleListener.pressX();
                break;
            case XboxOneMapping.BUTTON_Y:
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
            case XboxOneMapping.AXIS_LEFT_X:
                inputHandleListener.leftAxisX(axisCode, value);
                break;
            case XboxOneMapping.AXIS_LEFT_Y:
                inputHandleListener.leftAxisY(axisCode, value);
                break;
            case XboxOneMapping.AXIS_RIGHT_X:
                inputHandleListener.rightAxisX(axisCode, value);
                break;
            case XboxOneMapping.AXIS_RIGHT_Y:
                inputHandleListener.rightAxisY(axisCode, value);
                break;
        }

        return true;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        return false;
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

    }

}
