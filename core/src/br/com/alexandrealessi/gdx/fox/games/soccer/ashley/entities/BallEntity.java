package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.ScaledSprite;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 22/06/15.
 */
public class BallEntity extends UserEntity {
    public static final float SCALE_FACTOR = 0.78f;
    public static final String BALL = "ball";
    private Body ballBody;
    private Camera camera;
    private Sprite ball;
    private Fixture ballFixture;

    public BallEntity(TextureAtlas atlas, RubeSceneHelper rubeSceneHelper, Camera camera) {
        this(ScaledSprite.createUsingHeight(new Sprite(atlas.findRegion(BALL)), SCALE_FACTOR), rubeSceneHelper);
        this.camera = camera;
    }

    private BallEntity(ScaledSprite scaledSprite, RubeSceneHelper rubeSceneHelper) {
        this(scaledSprite.getSprite(), rubeSceneHelper.getBody("ball"), rubeSceneHelper);
    }

    private BallEntity(Sprite sprite, Body ballBody, RubeSceneHelper rubeSceneHelper) {
        this(rubeSceneHelper.getFixture(ballBody, "ball"));
        this.ball = sprite;
        this.ballBody = ballBody;
    }

    private BallEntity(Fixture ballFixture) {
        this.ballFixture = ballFixture;
    }

    @Override
    public Array<Component> getComponents() {
        Array<Component> components = new Array<Component>();
        components.add(PositionComponent.newInstance());
        components.add(CameraFollowerComponent.newInstance(camera));
        components.add(SpriteComponent.newInstance(ball));
        components.add(BodyComponent.newInstance(ballBody));
        components.add(BallContextComponent.newInstance());
        return components;
    }

    @Override
    public void init(Entity entity) {
        BodyComponent bodyComponent = entity.getComponent(BodyComponent.class);
        bodyComponent.setPosition(Vector2.Zero);
        ballFixture.setUserData(new FixtureUserData(FixtureType.BALL, entity));
    }
}
