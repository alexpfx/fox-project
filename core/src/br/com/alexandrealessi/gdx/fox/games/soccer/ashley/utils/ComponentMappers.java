package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.CameraFollowerComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.TouchDownInputComponent;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * Created by alexandre on 31/05/15.
 */
//TODO: adicionar outros.
public class ComponentMappers {
    public static final ComponentMapper<CameraComponent> CAMERA = ComponentMapper.getFor(CameraComponent.class);
    public static final ComponentMapper<TouchDownInputComponent> TOUCH_DOWN_INPUT = ComponentMapper.getFor(TouchDownInputComponent.class);
    public static final ComponentMapper<PositionComponent> POSITION = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<BodyComponent> BODY = ComponentMapper.getFor(BodyComponent.class);
    public static final ComponentMapper<CameraFollowerComponent> CAMERA_FOLLOWER = ComponentMapper.getFor(CameraFollowerComponent.class);

}
