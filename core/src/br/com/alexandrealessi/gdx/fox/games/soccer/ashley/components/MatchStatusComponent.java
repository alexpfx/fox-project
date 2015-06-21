package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by alexandre on 21/06/15.
 */
public class MatchStatusComponent extends Component {

    private MatchGameStatus gameStatus = MatchGameStatus.AFTER_BEGIN;

    public MatchGameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(MatchGameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public enum MatchGameStatus {
        AFTER_BEGIN, AFTER_GOAL, AFTER_HALF, AFTER_END, RUNNING;

        public boolean isOneOf(MatchGameStatus... matchGameStatuses) {
            for (MatchGameStatus status : matchGameStatuses) {
                if (status == this) {
                    return true;
                }
            }
            return false;
        }
    }
}