package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.base.input.Touch;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by alexandre on 31/05/15.
 */
public class TouchDownInputComponent extends Component {

    private Touch touch = new Touch();
    private boolean consumed = true;

    public void set(Vector3 coords) {
        set(coords.x, coords.y, touch.pointer, touch.button);
    }

    public void set(float x, float y, int pointer, int button) {
        touch.x = x;
        touch.y = y;
        touch.pointer = pointer;
        touch.button = button;
        consumed = false;
    }

    public Touch getTouch() {
        consumed = true;
        return touch;
    }

    public boolean isConsumed() {
        return consumed;
    }

}
