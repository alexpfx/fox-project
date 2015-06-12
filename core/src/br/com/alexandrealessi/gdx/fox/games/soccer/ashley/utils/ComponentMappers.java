package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.domain.team.TeamFormation;
import com.badlogic.ashley.core.ComponentMapper;

import static com.badlogic.ashley.core.ComponentMapper.getFor;

/**
 * Created by alexandre on 31/05/15.
 */
//TODO: adicionar outros.
public class ComponentMappers {
    public static final ComponentMapper<CameraComponent> CAMERA = getFor(CameraComponent.class);
    public static final ComponentMapper<TouchDownInputComponent> TOUCH_DOWN_INPUT =
            getFor(TouchDownInputComponent.class);
    public static final ComponentMapper<PositionComponent> POSITION = getFor(PositionComponent.class);
    public static final ComponentMapper<BodyComponent> BODY = getFor(BodyComponent.class);
    public static final ComponentMapper<CameraFollowerComponent> CAMERA_FOLLOWER =
            getFor(CameraFollowerComponent.class);
    public static final ComponentMapper<SpriteComponent> SPRITE_COMPONENT =
            getFor(SpriteComponent.class);
    public static final ComponentMapper<WorldComponent> WORLD = getFor(WorldComponent.class);

    public static final ComponentMapper<SteerComponent> STEER = getFor(SteerComponent.class);
    public static final ComponentMapper<PlayerMatchContextComponent> PLAYER_MATCH_CONTEXT = getFor(PlayerMatchContextComponent.class);
    public static final ComponentMapper<MatchScoreComponent> MATCH_CONTEXT = getFor(MatchScoreComponent.class);
    public static final ComponentMapper<TeamComponent> TEAM = getFor(TeamComponent.class);
    public static final ComponentMapper<MatchTimerComponent> MATCH_TIMER = getFor(MatchTimerComponent.class);

    public static final ComponentMapper<PlayerInfoComponent> PLAYER_INFO = getFor(PlayerInfoComponent.class);

    public static final ComponentMapper<PlayersComponent> PLAYERS = getFor(PlayersComponent.class);

    public static final ComponentMapper<TeamFormationComponent> TEAM_FORMATION = getFor(TeamFormationComponent.class);

    private static final ComponentMapper <TeamInfoComponent> TEAM_INFO = getFor(TeamInfoComponent.class);



}
