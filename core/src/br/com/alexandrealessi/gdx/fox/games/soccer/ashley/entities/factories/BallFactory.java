package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.SpriteComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by alexandre on 07/06/15.
 */
public class BallFactory implements EntityFactory {
    private TextureAtlas atlas;
    private RubeSceneHelper rubeSceneHelper;
    private Camera camera;
    private Rectangle SCENE_BOUNDS;



    private BallFactory(TextureAtlas atlas, RubeSceneHelper rubeSceneHelper, Camera camera, Rectangle SCENE_BOUNDS) {
        this.atlas = atlas;
        this.rubeSceneHelper = rubeSceneHelper;
        this.camera = camera;
        this.SCENE_BOUNDS = SCENE_BOUNDS;
    }

    public static BallFactory getInstance(TextureAtlas atlas, RubeSceneHelper rubeSceneHelper, Camera camera, Rectangle SCENE_BOUNDS) {
        return new BallFactory(atlas, rubeSceneHelper, camera, SCENE_BOUNDS);
    }

    @Override
    public Entity create() {
        final Entity ballEntity = new Entity();
        final Sprite ballSprite = new Sprite(atlas.findRegion("ball"));
        final Body ballBody = rubeSceneHelper.getBody("ball");
        final Fixture ball = rubeSceneHelper.getFixture(ballBody, "ball");
        ball.setUserData(new FixtureUserData(FixtureType.BALL, ballEntity));
        ballEntity.add(new SpriteComponent(ballSprite));
        ballEntity.add(new BodyComponent(ballBody));
        final PositionComponent positionComponent = new PositionComponent();
        ballEntity.add(positionComponent);
        ballEntity.add(new CameraFollowerComponent(camera, SCENE_BOUNDS));
        ballSprite.setScale(2 / ballSprite.getHeight());
        return ballEntity;
    }
}