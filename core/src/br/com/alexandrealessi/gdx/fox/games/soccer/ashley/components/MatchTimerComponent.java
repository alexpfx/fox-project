package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alex on 07/06/2015.
 */
public class MatchTimerComponent extends Component{

    private final float totalTime;
    private float timer;

    public MatchTimerComponent(float totalTime) {
        this.totalTime = totalTime;
    }

    public void increment(float seconds) {
        timer += seconds;
    }

    public float getTimer() {
        return timer;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public float timeToFinish() {
        return totalTime - timer;
    }

}
