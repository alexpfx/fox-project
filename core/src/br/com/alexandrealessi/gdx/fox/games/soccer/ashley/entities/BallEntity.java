package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.ScaledSprite;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by alexandre on 22/06/15.
 */
public class BallEntity extends UserEntity {
    public static final float SCALE_FACTOR = 0.78f;
    public static final String BALL = "ball";
    private Body ballBody;
    private Camera camera;
    private ScaledSprite ballSprite;
    private Fixture ballFixture;

    public BallEntity(ScaledSprite ballSprite, Body ballBody, Fixture ballFixture, Camera camera) {
        this.ballSprite = ballSprite;
        this.ballBody = ballBody;
        this.ballFixture = ballFixture;
        this.camera = camera;
    }

    @Override
    public Component[] getComponents() {
        return new Component[]{
                PositionComponent.newInstance(),
                CameraFollowerComponent.newInstance(camera),
                SpriteComponent.newInstance(ballSprite.getSprite()),
                BodyComponent.newInstance(ballBody),
                BallContextComponent.newInstance()};
    }

    @Override
    public void afterInit(Entity entity) {
        BodyComponent bodyComponent = entity.getComponent(BodyComponent.class);
        bodyComponent.setPosition(Vector2.Zero);
        ballFixture.setUserData(new FixtureUserData(FixtureType.BALL, entity));
    }
}



