package br.com.alexandrealessi.gdx.fox.multiplatform.services;

import com.badlogic.gdx.Gdx;

/**
 * TODO: melhorar descricao
 * //TODO: refatorar nome
 * Interface para chamadas as APIs de LeaderboardsInterface...
 */

public interface LeaderboardsInterface {
    void submitScore(String key, int score);

    void incrementAchievment(String achievmentId, int amount);

    void unlockAchievment(String achievmentId);

    static final LeaderboardsInterface NULL = new LeaderboardsInterface() {
        private final String tag = LeaderboardsInterface.class.getName();

        @Override
        public void submitScore(String key, int score) {
            Gdx.app.debug(tag, "LeaderboardsInterface API not instantiated.");
        }

        @Override
        public void incrementAchievment(String achievmentId, int amount) {
            Gdx.app.debug(tag, "LeaderboardsInterface API not instantiated.");
        }

        @Override
        public void unlockAchievment(String achievmentId) {
            Gdx.app.debug(tag, "LeaderboardsInterface API not instantiated.");
        }
    };

}
