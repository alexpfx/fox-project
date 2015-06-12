package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.box2d.BodyCloner;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.EntityUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.PlayerPosition;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.Team;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by alexandre on 08/06/15.
 */
public class PlayerFactory extends CreateAndAddToEngineEntityFactory {
    public static final String PLAYER_NUMBER = "NUMBER";
    public static final String PLAYER_POSITION = "PLAYER_POSITION";
    public static final String PLAYER_NAME = "PLAYER_NAME";
    public static final String UNIFORM = "UNIFORM";
    public static final String TEAM = "TEAM";
    public static final String INITIAL_POSITION = "INITIAL_POSITION";
    private RubeSceneHelper rubeSceneHelper;
    private BodyCloner bodyCloner;

    private PlayerFactory(RubeSceneHelper rubeSceneHelper) {
        this.rubeSceneHelper = rubeSceneHelper;
        bodyCloner = BodyCloner.newInstance();

    }

    public static PlayerFactory newInstance(RubeSceneHelper rubeSceneHelper) {
        return new PlayerFactory(rubeSceneHelper);
    }

    @Override
    public Entity create(CreateArguments arguments) {
        final ScaledSprite uniform = arguments.get(UNIFORM);

        Entity player = new Entity();

        final Body bodyModel = rubeSceneHelper.getBody("player");

        final Fixture bodyFixture = rubeSceneHelper.getFixture(bodyModel, "player_fixture");
        bodyFixture.setUserData(new FixtureUserData(FixtureType.PLAYER, player));

        final Body body = bodyCloner.clone(bodyModel);

        body.setUserData(EntityUserData.newInstance(player));
        Vector2 initialPosition = arguments.get(INITIAL_POSITION);
        body.setTransform(initialPosition.x, initialPosition.y, 0);

        player.add(BodyComponent.newInstance(body));

        final Sprite sprite = new Sprite(uniform.getSprite());
        player.add(SpriteComponent.newInstance(sprite));

        final Team team = arguments.get(TEAM);
        final PlayerPosition playerPosition = arguments.get(PLAYER_POSITION);
        final int number = arguments.get(PLAYER_NUMBER);
        player.add(PlayerMatchContextComponent.newInstance(team, playerPosition, number));

        player.add(PositionComponent.newInstance());

        String playerName = arguments.get(PLAYER_NAME);
        player.add(PlayerInfoComponent.newInstance(playerName));



        return player;
    }
}
