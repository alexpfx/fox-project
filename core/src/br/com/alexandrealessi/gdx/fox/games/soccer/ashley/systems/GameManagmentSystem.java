package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.box2d.MatchEventListener;
import br.com.alexandrealessi.gdx.fox.base.box2d.SoccerContactListener;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchScoreComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchTimerComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.MatchFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by alexandre on 07/06/15.
 */
public class GameManagmentSystem extends EntitySystem implements MatchEventListener {

    private Entity worldEntity;
    private Entity goalLineEntity;

    private MatchTimerComponent matchTimerComponent;
    private MatchScoreComponent matchScoreComponent;

    @Override
    public void addedToEngine(Engine engine) {
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).first();

        final WorldComponent worldComponent = ComponentMappers.WORLD.get(worldEntity);
        final World world = worldComponent.getWorld();
        world.setContactListener(new SoccerContactListener(this));

        Entity matchEntity = engine.getEntitiesFor(Family.all(MatchTimerComponent.class, MatchScoreComponent.class).get()).first();
        matchTimerComponent = ComponentMappers.MATCH_TIMER.get(matchEntity);

        matchScoreComponent = ComponentMappers.MATCH_CONTEXT.get(matchEntity);

        final ImmutableArray<Entity> entitiesFor = engine.getEntitiesFor(Family.one(TeamComponent.class).get());

    }

    @Override
    public void update(float deltaTime) {
        matchTimerComponent.increment(deltaTime);
    }

    @Override
    public void goal(Entity goalLineEntity) {
        final TeamComponent teamComponent = ComponentMappers.TEAM.get(goalLineEntity);
        final Team team = teamComponent.getTeam();
        if (team.equals(matchScoreComponent.getHomeTeam())){
            matchScoreComponent.incrementAwayScore();
        } else {
            matchScoreComponent.incrementHomeScore();
        }
        System.out.println();
        System.out.println("Away Score: "+matchScoreComponent.getAwayScore());
        System.out.println("Home Score:  "+matchScoreComponent.getHomeScore());


    }
}
