package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
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
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 13/06/15.
 */
public class OrganizeTeamToMatchSystem extends IteratingSystem {

    private ImmutableArray<Entity> teams;
    private RubeSceneHelper rubeSceneHelper;
    private Engine engine;

    public OrganizeTeamToMatchSystem(Family family, RubeSceneHelper rubeSceneHelper) {
        super(Family.all(TeamFormationComponent.class, TeamInfoComponent.class, TeamMatchContext.class).get());
        this.rubeSceneHelper = rubeSceneHelper;
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;

    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        final TeamFormationComponent formationComponent = ComponentMappers.TEAM_FORMATION.get(entity);
        final TeamInfoComponent teamInfoComponent = ComponentMappers.TEAM_INFO.get(entity);
        final TeamMatchContext teamMatchContext = ComponentMappers.TEAM_MATCH.get(entity);

        createPlayers(entity, formationComponent.getFormation(), teamInfoComponent, teamMatchContext.getTeamSide());

    }

    private void createPlayers(Entity entity, TeamFormation formation, TeamInfoComponent teamInfoComponent, TeamSide side) {
        FormationOrganizer organizer = new FormationOrganizer(formation, FormationOrganizer.FormationOrganizerType.FIXED, side);
        PlayerFactory playerFactory = PlayerFactory.newInstance(rubeSceneHelper);
        final Array<OrganizedParameters> organized = organizer
                .organize();

        for (OrganizedParameters v : organized) {
            CreateArguments arguments = new CreateArguments();
            arguments.put(PlayerFactory.INITIAL_POSITION, v.getInitialPosition());
            arguments.put(PlayerFactory.PLAYER_NAME, "name");
            arguments.put(PlayerFactory.PLAYER_POSITION, v.getPlayerPosition());
            arguments.put(PlayerFactory.TEAM, entity);
            arguments.put(PlayerFactory.UNIFORM, teamInfoComponent.getMainUniform());
            playerFactory.createAndAddToEngine(arguments, engine);
        }

    }

}
