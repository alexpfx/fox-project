package br.com.alexandrealessi.gdx.fox.base.utils;

/**
 * Created by alexandre on 19/04/15.
 */
public interface RequestHandler {

    static RequestHandler NULL = new RequestHandler() {
        @Override
        public boolean isConnected() {
            return false;
        }

        @Override
        public void submitScore(String key, long score) {

        }

        @Override
        public void incrementAchievment(String achievmentId, int amount) {

        }

        @Override
        public void unlockAchievment(String achievmentId) {

        }

        @Override
        public void setPlusOneButtonVisible(boolean visible) {

        }
    };

    boolean isConnected();

    void submitScore(String key, long score);

    void incrementAchievment(String achievmentId, int amount);

    void unlockAchievment(String achievmentId);

    void setPlusOneButtonVisible(boolean visible);

}
