package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchScoreComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchStatusComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchTimerComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.Team;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 07/06/15.
 */
public class MatchFactory extends CreateAndAddToEngineEntityFactory {
    private float matchTotalTime;
    private Entity homeTeam;
    private Entity awayTeam;

    private MatchFactory(float matchTotalTime, Entity homeTeam, Entity awayTeam) {
        this.matchTotalTime = matchTotalTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public static MatchFactory newInstance(float matchTotalTime, Entity homeTeam, Entity awayTeam) {
        return new MatchFactory(matchTotalTime, homeTeam, awayTeam);
    }

    @Override
    public Entity create(CreateArguments arguments) {
        Entity entity = new Entity();
        entity.add(new MatchTimerComponent(matchTotalTime));
        entity.add(new MatchScoreComponent(homeTeam, awayTeam));
        entity.add(new MatchStatusComponent());
        return entity;
    }



}
