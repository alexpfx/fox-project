package br.com.alexandrealessi.gdx.fox.base.box2d;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PlayerMatchContextComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Entity;

/**
 * Created by alex on 06/06/2015.
 */
public class SoccerContactListener extends SoccerResolverContactListener {


    @Override
    protected void contactBallPlayer(FixtureUserData ballUserData, FixtureUserData playerUserData) {

    }

    @Override
    protected void contactBallGoalLine(FixtureUserData ballUserData, FixtureUserData goalLine) {




    }

    @Override
    protected void contactPlayerPlayer(FixtureUserData playerAUserData, FixtureUserData playerBUserData) {

    }
}
