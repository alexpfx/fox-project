package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 10/06/15.
 */
public class FormationOrganizer {

    private TeamFormation teamFormation;
    private Array<Vector2> positionArray;
    private float scale = 0;

    public FormationOrganizer(TeamFormation teamFormation, Array<Vector2> positionArray, float scale) {
        this.teamFormation = teamFormation;
        this.positionArray = positionArray;
        this.scale = scale;
    }

    public Array<Vector2> organize() {
        final FormationGroup defenderFormation = teamFormation.getDefenderFormation();
        final FormationGroup middlefieldFormation = teamFormation.getMiddlefieldFormation();
        final FormationGroup attackerFormation = teamFormation.getAttackerFormation();
        Array<Vector2> array = new Array<Vector2>();

        for (PlayerPosition pp : defenderFormation.getPositionArray()) {

        }
        for (PlayerPosition pp : middlefieldFormation.getPositionArray()) {

        }
        for (PlayerPosition pp : attackerFormation.getPositionArray()) {

        }

        return null;

    }

}
