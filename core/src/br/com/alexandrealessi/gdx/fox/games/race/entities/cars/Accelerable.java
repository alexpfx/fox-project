package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

/**
 * Created by alexandre on 02/05/15.
 */
public interface Accelerable {
    void accelerate (float amount, float direction);
    void brek (float amount);
}
