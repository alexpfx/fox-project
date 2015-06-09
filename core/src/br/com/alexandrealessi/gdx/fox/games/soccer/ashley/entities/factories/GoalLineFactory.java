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

    public static final String TEAM = "team";
    public static final String GOAL_LINE_BODY_NAME = "goal_line_body_name";
    private RubeSceneHelper rubeSceneHelper;

    private GoalLineFactory(RubeSceneHelper rubeSceneHelper) {
        this.rubeSceneHelper = rubeSceneHelper;
    }

    public static GoalLineFactory newInstance(RubeSceneHelper rubeSceneHelper) {
        return new GoalLineFactory(rubeSceneHelper);
    }


    @Override
    public Entity create(CreateArguments map) {
        Team team = map.get(TEAM);
        String goalLineBodyName = map.get(GOAL_LINE_BODY_NAME);
        if (team == null || goalLineBodyName == null){
            throw new IllegalArgumentException("team or body name don't passed as arguments");
        }
        Entity entity = new Entity();
        final Body body = rubeSceneHelper.getBody(goalLineBodyName);
        entity.add(BodyComponent.newInstance(body));
        final Fixture goalLineLeftFixture = rubeSceneHelper.getFixture(body, "line");
        goalLineLeftFixture.setUserData(new FixtureUserData(FixtureType.GOAL_LINE, entity));
        entity.add(new TeamComponent(team));
        return entity;

    }

}
