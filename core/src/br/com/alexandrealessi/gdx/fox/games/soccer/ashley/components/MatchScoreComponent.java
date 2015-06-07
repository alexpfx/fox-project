package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 31/05/15.
 */
public class MatchScoreComponent extends Component {

    private Team homeTeam;
    private int homeScore = 0;

    private Team awayTeam;
    private int awayScore = 0;


    public MatchScoreComponent(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getHomeTeam() {
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
