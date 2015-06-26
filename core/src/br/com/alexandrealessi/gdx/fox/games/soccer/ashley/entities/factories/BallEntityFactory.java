package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.BallEntity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by alexandre on 25/06/15.
 */
public class BallEntityFactory {

    private final TextureAtlas atlas;
    private final RubeSceneHelper rubeSceneHelper;

    public BallEntityFactory(TextureAtlas atlas, RubeSceneHelper rubeSceneHelper) {
        this.atlas = atlas;
        this.rubeSceneHelper = rubeSceneHelper;
    }

    public BallEntity createBallEntity(String ballImageName, float scaleFactor, Camera camera) {
        Sprite ballSprite = new Sprite(atlas.findRegion(ballImageName));
        Body ballBody = rubeSceneHelper.getBody("ball");
        ScaledSprite scaledSprite = ScaledSprite.createUsingHeight(ballSprite, scaleFactor);
        Fixture fixture = rubeSceneHelper.getFixture(ballBody, "ball");
        return new BallEntity(scaledSprite, ballBody, fixture, camera);
    }
}
