package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.*;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchStatusComponent.MatchGameStatus;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;

import static br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.MatchStatusComponent.MatchGameStatus.*;

/**
 * Created by alexandre on 21/06/15.
 */
public class TeamResetSystem extends EntitySystem {
    private ImmutableArray<Entity> players;
    private Entity match;
    private Entity ball;
    private Entity world;

    @Override
    public void addedToEngine(Engine engine) {
        players = engine.getEntitiesFor(Family.all(PlayerInfoComponent.class, PlayerMatchContextComponent.class).get());
        match = engine.getEntitiesFor(Family.one(MatchStatusComponent.class).get()).first();
        ball = engine.getEntitiesFor(Family.one(BallContextComponent.class).get()).first();
        world = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).first();
    }

    @Override
    public void update(float deltaTime) {
        final MatchStatusComponent matchStatusComponent = ComponentMappers.MATCH_STATUS.get(match);
        final MatchGameStatus gameStatus = matchStatusComponent.getGameStatus();
        final WorldComponent worldComponent = ComponentMappers.WORLD.get(world);

        if (gameStatus.isOneOf(AFTER_BEGIN, AFTER_GOAL, AFTER_HALF)) {
            resetTeamToPosition();
            resetBall();
        }
        matchStatusComponent.setGameStatus(RUNNING);
    }

    private void resetBall() {
        final BodyComponent bodyComponent = ComponentMappers.BODY.get(ball);
        bodyComponent.setPosition(Vector2.Zero);
        bodyComponent.setLinearVelocity(0, 0);
    }

    private void resetTeamToPosition() {
        for (Entity player : players) {
            resetPlayer(player);
        }

    }

    private void resetPlayer(Entity player) {
        final PlayerMatchContextComponent playerMatchContextComponent = ComponentMappers.PLAYER_MATCH_CONTEXT
                .get(player);
        final Vector2 initialPosition = playerMatchContextComponent.getInitialPosition();
        final BodyComponent bodyComponent = ComponentMappers.BODY.get(player);
        bodyComponent.setPosition(initialPosition);
        bodyComponent.setLinearVelocity(0, 0);
    }
}
