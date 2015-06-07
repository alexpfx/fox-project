package br.com.alexandrealessi.gdx.fox.base.box2d;

import br.com.alexandrealessi.gdx.fox.FixtureUserData;

/**
 * Created by alex on 06/06/2015.
 */
public class SoccerContactListener extends SoccerResolverContactListener {

    MatchEventListener listener;

    public SoccerContactListener(MatchEventListener listener) {
        this.listener = listener;
    }

    @Override
    protected void contactBallPlayer(FixtureUserData ballUserData, FixtureUserData playerUserData) {

    }

    @Override
    protected void contactBallGoalLine(FixtureUserData ballUserData, FixtureUserData goalLine) {
        listener.goal(goalLine.getEntity());
    }

    @Override
    protected void contactPlayerPlayer(FixtureUserData playerAUserData, FixtureUserData playerBUserData) {

    }
}
