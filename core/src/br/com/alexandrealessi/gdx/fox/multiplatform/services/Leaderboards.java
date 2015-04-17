package br.com.alexandrealessi.gdx.fox.multiplatform.services;

import com.badlogic.gdx.Gdx;
import sun.rmi.runtime.Log;

/**
 * TODO: melhorar descrição
 * Interface para chamadas as APIs de Leaderboards...
 */
public interface Leaderboards {
    void submitScore(String key, int score);

    void incrementAchievment(String achievmentId, int amount);

    void unlockAchievment(String achievmentId);

    static final Leaderboards NULL = new Leaderboards() {
        private final String tag = Leaderboards.class.getName();

        @Override
        public void submitScore(String key, int score) {
            Gdx.app.debug(tag, "Leaderboards API not instantiated.");
        }

        @Override
        public void incrementAchievment(String achievmentId, int amount) {
            Gdx.app.debug(tag, "Leaderboards API not instantiated.");
        }

        @Override
        public void unlockAchievment(String achievmentId) {
            Gdx.app.debug(tag, "Leaderboards API not instantiated.");
        }
    };

}
