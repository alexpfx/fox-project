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

    private final Vector2 worldSize;
    int x = 0;

    public PlayerBuilder(Vector2 worldSize) {
        this.worldSize = worldSize;
    }

    public Player createPlayerEntity(PlayerData playerData, Sprite playerUniform, Body bodyModel) {
        PlayerBuilder pb = new PlayerBuilder(worldSize);
        final Player player = new Player(playerData.name, playerData.number, playerData.position);
        attachComponents(player, playerUniform, bodyModel);
        return player;
    }

    private void attachComponents(Player playerEntity, Sprite uniform, Body bodyModel) {
        playerEntity.add(new PositionComponent());
        playerEntity.add(new SpriteComponent(uniform));
        final BodyBuilder cloneBuilder = BodyBuilder.clone(bodyModel);
        final Body body = cloneBuilder.build();
        body.setTransform(MathUtils.random(-50, 50), MathUtils.random(-50, 50), 0);
        System.out.println(body.getPosition());
        playerEntity.add(new BodyComponent(body));
        final SteerComponent steer = new SteerComponent(body, true, 0.15f, worldSize);
        playerEntity.add(steer);

        Wander<Vector2> wander = new Wander<Vector2>(steer).setFaceEnabled(true)
                .setAlignTolerance(0.1f) // Used by Face
                .setDecelerationRadius(5) // Used by Face
                .setTimeToTarget(0.1f) // Used by Face
                .setWanderOffset(40) //
                .setWanderOrientation(60) //
                .setWanderRadius(90) //
                .setWanderRate(MathUtils.PI / 5).setEnabled(true);
        steer.setSteeringBehavior(wander);

        body.setUserData(PlayerUserData.getFor(playerEntity));
    }

}
