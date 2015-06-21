package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchStatusComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamFormationComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamInfoComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamMatchContext;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.CreateArguments;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.PlayerFactory;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.FormationOrganizer;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.OrganizedParameters;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.TeamFormation;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

import static br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchStatusComponent.MatchGameStatus.*;

/**
 * Created by alexandre on 13/06/15.
 */
public class TeamOrganizeSystem extends EntitySystem {

    private ImmutableArray<Entity> teams;
    private RubeSceneHelper rubeSceneHelper;
    private Engine engine;
    private ImmutableArray<Entity> teamEntities;
    private Entity match;

    public TeamOrganizeSystem(RubeSceneHelper rubeSceneHelper) {
        this.rubeSceneHelper = rubeSceneHelper;
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
        teamEntities = engine.getEntitiesFor(Family
                .all(TeamFormationComponent.class, TeamInfoComponent.class, TeamMatchContext.class).get());
        match = engine.getEntitiesFor(Family.one(MatchStatusComponent.class).get()).first();
    }

    protected void organizeTeam(Entity entity) {
        final TeamFormationComponent formationComponent = ComponentMappers.TEAM_FORMATION.get(entity);
        final TeamInfoComponent teamInfoComponent = ComponentMappers.TEAM_INFO.get(entity);
        final TeamMatchContext teamMatchContext = ComponentMappers.TEAM_MATCH.get(entity);
        createPlayers(entity, formationComponent.getFormation(), teamInfoComponent, teamMatchContext.getTeamSide());
    }


    /* nao pode criar aqui. deve somente organizar nas posicoes */
    private void createPlayers(Entity entity, TeamFormation formation, TeamInfoComponent teamInfoComponent, TeamSide side) {
        FormationOrganizer organizer = new FormationOrganizer(formation, FormationOrganizer.FormationOrganizerType.FIXED, side);
        PlayerFactory playerFactory = PlayerFactory.newInstance(rubeSceneHelper);
        final Array<OrganizedParameters> organized = organizer
                .organize();

        int i = 1;
        for (OrganizedParameters v : organized) {
            CreateArguments arguments = new CreateArguments();
            arguments.put(PlayerFactory.INITIAL_POSITION, v.getInitialPosition());
            arguments.put(PlayerFactory.PLAYER_NAME, "name");
            arguments.put(PlayerFactory.PLAYER_POSITION, v.getPlayerPosition());
            arguments.put(PlayerFactory.TEAM, entity);
            arguments.put(PlayerFactory.UNIFORM, teamInfoComponent.getMainUniform());
            arguments.put(PlayerFactory.PLAYER_NUMBER, i++);
            playerFactory.createAndAddToEngine(arguments, engine);
        }

    }

    @Override
    public void update(float deltaTime) {
        final MatchStatusComponent matchStatusComponent = ComponentMappers.MATCH_STATUS.get(match);
        if (matchStatusComponent.getGameStatus()
                                .isOneOf(AFTER_BEGIN, AFTER_GOAL, AFTER_HALF)) {
            organizeTeams();
            matchStatusComponent.setGameStatus(RUNNING);
        }
    }

    private void organizeTeams() {
        for (Entity entity : teamEntities) {
            organizeTeam(entity);
        }
    }

}
