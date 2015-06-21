package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamFormationComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamInfoComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamMatchContextComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.TeamFormation;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alexandre on 11/06/15.
 */
public class TeamFactory extends CreateAndAddToEngineEntityFactory{

    public static final String TEAM_SIDE = "team.side";
    public static final String TEAM_NAME = "team.name";
    public static final String TEAM_MAIN_UNIFORM = "team.main.uniform";
    public static final String TEAM_GK_UNIFORM = "team.gk.uniform";
    public static final String TEAM_FORMATION = "team.formation";
    public static final String TEAM_IS_USER_TEAM = "team.isUserTeam";

    private int numberOfPlayers = 11;
    private RubeSceneHelper rubeSceneHelper;

    private TeamFactory(int numberOfPlayers, RubeSceneHelper rubeSceneHelper) {
        this.numberOfPlayers = numberOfPlayers;
        this.rubeSceneHelper = rubeSceneHelper;
    }

    public static TeamFactory newInstance(int numberOfPlayers, RubeSceneHelper rubeSceneHelper) {
        return new TeamFactory(numberOfPlayers, rubeSceneHelper);
    }

    @Override
    public Entity create(CreateArguments arguments) {
        Entity entity = new Entity();

        createAndAddTeamInfo(entity, arguments);
        createAndAddTeamMatchContext (entity, arguments);
        createAndAddTeamFormation (entity, arguments);

        return entity;
    }

    private void createAndAddTeamFormation(Entity entity, CreateArguments arguments) {
        TeamFormation formation = arguments.get(TEAM_FORMATION);
        TeamFormationComponent teamFormationComponent = TeamFormationComponent.newInstance(formation);
        entity.add(teamFormationComponent);
    }

    private void createAndAddTeamMatchContext(Entity entity, CreateArguments arguments) {
        TeamSide teamSide = arguments.get(TEAM_SIDE);
        boolean isUserTeam = arguments.get(TEAM_IS_USER_TEAM, false);
        TeamMatchContextComponent teamMatchContextComponent = TeamMatchContextComponent
                .newInstance(teamSide, isUserTeam);
        entity.add(teamMatchContextComponent);
    }

    private void createAndAddTeamInfo(Entity entity, CreateArguments arguments){
        String name = arguments.get(TEAM_NAME);
        ScaledSprite mainUniform = arguments.get(TEAM_MAIN_UNIFORM);
        ScaledSprite gkUniform = arguments.get(TEAM_GK_UNIFORM);
        TeamInfoComponent teamInfoComponent = TeamInfoComponent.newInstance(name, mainUniform, gkUniform);
        entity.add(teamInfoComponent);
    }

}
