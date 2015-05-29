package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SteerComponent;
import br.com.alexandrealessi.gdx.fox.base.utils.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Player;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import com.badlogic.gdx.ai.steer.behaviors.Wander;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 25/05/15.
 */
public class PlayerBuilder {

    int x = 0;

    public Player createPlayerEntity(PlayerData playerData, Sprite playerUniform, Body bodyModel) {
        PlayerBuilder pb = new PlayerBuilder();
        final Player player = new Player(playerData.name, playerData.number, playerData.position);
        attachComponents(player, playerUniform, bodyModel);
        return player;
    }

    private void attachComponents(Player playerEntity, Sprite uniform, Body bodyModel) {
        playerEntity.add(new PositionComponent());
        playerEntity.add(new SpriteComponent(uniform));
        final BodyBuilder cloneBuilder = BodyBuilder.clone(bodyModel);
        final Body body = cloneBuilder.build();
        body.getPosition().set(10, 10);
        playerEntity.add(new BodyComponent(body));
        final SteerComponent steer = new SteerComponent(body, true);
        playerEntity.add(steer);
        if (x++ == 10) {
            Wander<Vector2> wander = new Wander<Vector2>(steer).setFaceEnabled(true).setAlignTolerance(0.001f)
                                                               .setDecelerationRadius(5).setTimeToTarget(0.1f)
                                                               .setWanderOffset(90).setWanderOrientation(10)
                                                               .setWanderRadius(40).setWanderRate(MathUtils.PI / 5);
            steer.setSteeringBehavior(wander);
        }

        body.setUserData(PlayerUserData.getFor(playerEntity));
    }

}
