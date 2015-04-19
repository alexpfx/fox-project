package br.com.alexandrealessi.gdx.fox.android.model.interactors;

/**
 * Created by alexandre on 19/04/15.
 */
public interface LeaderboardInteractor {
    void submitScore(String key, long score);

    void incrementAchievment(String achievmentId, int amount);

    void unlockAchievment(String achievmentId);
}
