package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TeamComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Team;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by alexandre on 07/06/15.
 */
public class GoalLineFactory extends CreateAndAddToEngineEntityFactory {

    private RubeSceneHelper rubeSceneHelper;
    private Team team;
    private String goalLineBodyName;

    private GoalLineFactory(RubeSceneHelper rubeSceneHelper) {
        this.rubeSceneHelper = rubeSceneHelper;
    }

    public static GoalLineFactory getInstance(RubeSceneHelper rubeSceneHelper) {
        return new GoalLineFactory(rubeSceneHelper);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setGoalLineBodyName(String goalLineBodyName) {
        this.goalLineBodyName = goalLineBodyName;
    }

    @Override
    public Entity create() {
        if (team == null || goalLineBodyName == null){
            throw new IllegalArgumentException("usar setTeam para setar o time");
        }



        Entity entity = new Entity();

        final Body body = rubeSceneHelper.getBody(goalLineBodyName);
        entity.add(new BodyComponent(body));

        final Fixture goalLineLeftFixture = rubeSceneHelper.getFixture(body, "line");
        goalLineLeftFixture.setUserData(new FixtureUserData(FixtureType.GOAL_LINE, entity));
        entity.add(new TeamComponent(team));
        team = null;
        goalLineBodyName = null;
        return entity;
    }

}
