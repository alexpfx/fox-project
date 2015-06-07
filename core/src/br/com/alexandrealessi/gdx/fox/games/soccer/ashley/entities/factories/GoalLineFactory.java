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
public class GoalLineFactory extends CreateAndAddToEngineFactory {

    private RubeSceneHelper rubeSceneHelper;
    private Team team;

    private GoalLineFactory(RubeSceneHelper rubeSceneHelper) {
        this.rubeSceneHelper = rubeSceneHelper;
    }

    public static GoalLineFactory getInstance(RubeSceneHelper rubeSceneHelper) {
        return new GoalLineFactory(rubeSceneHelper);
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    @Override
    public Entity create() {
        if (team == null){
            throw new IllegalArgumentException("usar setTeam para setar o time");
        }
        Entity entity = new Entity();
        final Body goalLineLeftBody = rubeSceneHelper.getBody("goal_line_left");
        entity.add(new BodyComponent(goalLineLeftBody));

        final Fixture goalLineLeftFixture = rubeSceneHelper.getFixture(goalLineLeftBody, "line");
        goalLineLeftFixture.setUserData(new FixtureUserData(FixtureType.GOAL_LINE, entity));
        entity.add(new TeamComponent(team));

        return entity;
    }

}
