package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * Created by alexandre on 31/05/15.
 */
//TODO: adicionar outros.
public class ComponentMappers {
    public static final ComponentMapper<CameraComponent> CAMERA = ComponentMapper.getFor(CameraComponent.class);
    public static final ComponentMapper<TouchDownInputComponent> TOUCH_DOWN_INPUT = ComponentMapper
            .getFor(TouchDownInputComponent.class);
    public static final ComponentMapper<PositionComponent> POSITION = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<BodyComponent> BODY = ComponentMapper.getFor(BodyComponent.class);
    public static final ComponentMapper<CameraFollowerComponent> CAMERA_FOLLOWER = ComponentMapper
            .getFor(CameraFollowerComponent.class);
    public static final ComponentMapper<SpriteComponent> SPRITE_COMPONENT = ComponentMapper
            .getFor(SpriteComponent.class);
    public static final ComponentMapper<WorldComponent> WORLD = ComponentMapper.getFor(WorldComponent.class);

    public static final ComponentMapper<SteerComponent> STEER = ComponentMapper.getFor(SteerComponent.class);
    public static final ComponentMapper<PlayerMatchContextComponent> MATCH_CONTEXT = ComponentMapper.getFor(PlayerMatchContextComponent.class);

}
