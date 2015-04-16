package br.com.alexandrealessi.gdx.fox.multiplatform.services;

/** TODO: melhorar descrição
 * Interface para chamadas as APIs de Leaderboards...
 */
public interface Leaderboards {
    void submitScore (String key, int score);
    void incrementAchievment (String achievmentId, int amount);
    void unlockAchievment (String achievmentId);

}
