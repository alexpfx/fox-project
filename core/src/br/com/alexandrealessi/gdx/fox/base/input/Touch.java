package br.com.alexandrealessi.gdx.fox.base.input;

import com.badlogic.gdx.utils.*;

/**
 * Created by alexandre on 31/05/15.
 */
public class Touch {
    public float x;
    public float y;
    public int pointer;
    public int button;


    private com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(100);
    @Override
    public String toString() {
        stringBuilder.setLength(0);
        stringBuilder.append("x: ").append(x);
        stringBuilder.append("y: ").append(y);
        stringBuilder.append("pointer: ").append(pointer);
        stringBuilder.append("button: ").append(button);
        return stringBuilder.toString();
    }

}
