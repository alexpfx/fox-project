package br.com.alexandrealessi.gdx.fox.base;

/**
 * Created by alexandre on 27/05/15.
 */
public interface UserData {
    public UserData NULL = new UserData() {
        @Override
        public boolean canDestroy() {
            return false;
        }
    };

    boolean canDestroy();

}
