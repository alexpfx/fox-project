package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by alexandre on 25/05/15.
 */
public enum PlayerPosition {
    GK(new Vector2(90, 0), new Vector2(1, 1)),
    SW(new Vector2(80, 0), new Vector2(10, 10)),

    LB(new Vector2(70, 0), new Vector2(10, 10)),
    RB(new Vector2(70, 0), new Vector2(10, 10)),

    CB(new Vector2(70, 0), new Vector2(10, 10)),
    LCB(new Vector2(70, 0), new Vector2(10, 10)),
    RCB(new Vector2(70, 0), new Vector2(10, 10)),

    LWB(new Vector2(70, 0), new Vector2(10, 10)),
    RWB(new Vector2(70, 0), new Vector2(10, 10)),

    CDM(new Vector2(70, 0), new Vector2(10, 10)),
    LDM(new Vector2(70, 0), new Vector2(10, 10)),
    RDM(new Vector2(70, 0), new Vector2(10, 10)),

    CM(new Vector2(70, 0), new Vector2(10, 10)),
    RCM(new Vector2(70, 0), new Vector2(10, 10)),
    LCM(new Vector2(70, 0), new Vector2(10, 10)),

    AM(new Vector2(70, 0), new Vector2(10, 10)),
    LAM(new Vector2(70, 0), new Vector2(10, 10)),
    RAM(new Vector2(70, 0), new Vector2(10, 10)),

    LW(new Vector2(70, 0), new Vector2(10, 10)),
    RW(new Vector2(70, 0), new Vector2(10, 10)),

    CF(new Vector2(70, 0), new Vector2(10, 10)),
    ST(new Vector2(70, 0), new Vector2(10, 10)),
    LST(new Vector2(70, 0), new Vector2(10, 10)),
    RST(new Vector2(70, 0), new Vector2(10, 10)),;

    private Vector2 initialPosition;
    private Vector2 delta;

    PlayerPosition(Vector2 position, Vector2 delta) {
        this.initialPosition = position;
        this.delta = delta;
    }

    public Vector2 getInitialPosition() {
        return initialPosition;
    }

    public Vector2 getDelta() {
        return delta;
    }
}
