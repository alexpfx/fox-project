package br.com.alexandrealessi.gdx.fox.car;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 26/04/15.
 */
public enum SizeConstants {

    WORLD(new Vector2(80f, 48f)), SCREEN(new Vector2(800f, 480f));

    private Vector2 size;

    private SizeConstants(Vector2 size) {
        this.size = size;
    }

    public float width() {
        return size.x;
    }

    public float height() {
        return size.y;
    }

    public float hratio (SizeConstants sizeConstants){
        return size.scl(1 / height()).x;
    }

    public Vector2 size (){
        return size;
    }



}
