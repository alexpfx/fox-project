package br.com.alexandrealessi.gdx.fox.android.presenter;

/**
 * Created by alexandre on 19/04/15.
 */
public interface GooglePlayServicesPresenter {

    void connect();

    void disconnect();

    void submitScore(String key, long score);

    void incrementAchievment(String achievmentId, int amount);

    void unlockAchievment(String achievmentId);

}
