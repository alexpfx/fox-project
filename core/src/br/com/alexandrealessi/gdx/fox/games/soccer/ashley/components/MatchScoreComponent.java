package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 31/05/15.
 */
public class MatchScoreComponent extends Component {

    private Entity homeTeam;
    private int homeScore = 0;

    private Entity awayTeam;
    private int awayScore = 0;

    public MatchScoreComponent(Entity homeTeam, Entity awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Entity getAwayTeam() {
        return awayTeam;
    }

    public Entity getHomeTeam() {
        return homeTeam;
    }

    public void resetScore() {
        awayScore = 0;
        homeScore = 0;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void incrementHomeScore() {
        homeScore++;
    }

    public void incrementAwayScore() {
        awayScore++;
    }

}
