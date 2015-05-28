package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.utils;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.base.utils.BodyBuilder;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.Player;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.PlayerUserData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 25/05/15.
 */
public class PlayerBuilder {

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
        body.setUserData(PlayerUserData.getFor(playerEntity));
    }

}
