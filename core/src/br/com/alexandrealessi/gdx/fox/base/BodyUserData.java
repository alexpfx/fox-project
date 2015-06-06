package br.com.alexandrealessi.gdx.fox.base;

/**
 * Created by alexandre on 27/05/15.
 */
public interface BodyUserData {
    BodyUserData NULL = new BodyUserData() {
        @Override
        public boolean canDestroy() {
            return false;
        }
    };

    boolean canDestroy();

}
