package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.base.FixtureType;
import br.com.alexandrealessi.gdx.fox.base.box2d.RubeSceneHelper;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories.ScaledSprite;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 22/06/15.
 */
    public class BallEntity extends UserEntity {
        private final RubeSceneHelper rubeSceneHelper;
        private ScaledSprite ballSprite;
        private Body ballBody;
        private Camera camera;

        public BallEntity(ScaledSprite ballSprite, Body ballBody, Camera camera, RubeSceneHelper rubeSceneHelper) {
            this.ballSprite = ballSprite;
            this.ballBody = ballBody;
            this.camera = camera;
            this.rubeSceneHelper = rubeSceneHelper;
        }

        @Override
        public Array<Component> getComponents() {
            Array<Component> components = new Array<Component>();
            components.add(PositionComponent.newInstance());
            components.add(CameraFollowerComponent.newInstance(camera));
            components.add(SpriteComponent.newInstance(ballSprite.getSprite()));
            components.add(BodyComponent.newInstance(ballBody));
            components.add(BallContextComponent.newInstance());
            return components;
        }

        @Override
        public void init(Entity entity) {
            BodyComponent bodyComponent = entity.getComponent(BodyComponent.class);
            bodyComponent.setPosition(Vector2.Zero);

            Fixture ballFixture = rubeSceneHelper.getFixture(bodyComponent.getBody(), "ball");
            ballFixture.setUserData(new FixtureUserData(FixtureType.BALL, entity));
        }
    }
