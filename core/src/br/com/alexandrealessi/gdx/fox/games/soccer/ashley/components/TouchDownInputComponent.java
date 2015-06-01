package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.input.Touch;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.StringBuilder;

/**
 * Created by alexandre on 31/05/15.
 */
public class TouchDownInputComponent extends Component {

    private Touch touch;
    private boolean consumed;


    public void set (Vector3 coords){
        set(coords.x, coords.y, touch.pointer, touch.button);
    }

    public void set (float x, float y, int pointer, int button){
        touch.x = x;
        touch.y = y;
        touch.pointer = pointer;
        touch.button = button;
        consumed = false;
    }

    public Touch getTouch (){
        consumed = true;
        return touch;
    }

    public boolean isConsumed() {
        return consumed;
    }

}
