package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sun.deploy.util.ArrayUtil;
import net.dermetfan.gdx.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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

    public Array<Vector2> organize(FormationOrganizerType type) {
        final FormationGroup defenderFormation = teamFormation.getDefenderFormation();
        final FormationGroup middlefieldFormation = teamFormation.getMiddlefieldFormation();
        final FormationGroup attackerFormation = teamFormation.getAttackerFormation();
        Array<Vector2> array = new Array<Vector2>();

        for (PlayerPosition pp : defenderFormation.getPositionArray()) {
            Vector2 position = getPosition (pp, type);
            array.add(position);
        }
        for (PlayerPosition pp : middlefieldFormation.getPositionArray()) {
            Vector2 position = getPosition (pp, type);
            array.add(position);
        }
        for (PlayerPosition pp : attackerFormation.getPositionArray()) {
            Vector2 position = getPosition (pp, type);
            array.add(position);
        }
        return array;
    }

    private Vector2 getPosition(PlayerPosition pp, FormationOrganizerType type) {
        return null;
    }

    enum FormationOrganizerType {
        RANDOM, FIXED
    }

}
