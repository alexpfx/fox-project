package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alexandre on 14/06/15.
 */
public class InputHandle implements ControllerListener {

    @Override
    public void connected(Controller controller) {
    }

    @Override
    public void disconnected(Controller controller) {
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        System.out.println("buttonCode:" + buttonCode);
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        return true;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {

        return false;
    }

}
