package br.com.alexandrealessi.gdx.fox.base;

import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 27/05/15.
 */
public interface UserData {
    boolean canDestroy();

    public UserData NULL = new UserData() {
        @Override
        public boolean canDestroy() {
            return false;
        }
    };

}
