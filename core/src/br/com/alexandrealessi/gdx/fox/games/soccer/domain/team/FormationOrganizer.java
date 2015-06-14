package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 10/06/15.
 */
public class FormationOrganizer {

    private TeamFormation teamFormation;

    public FormationOrganizer(TeamFormation teamFormation) {
        this.teamFormation = teamFormation;
    }

    public Array<OrganizedParameters> organize(FormationOrganizerType type) {
        final FormationGroup defenderFormation = teamFormation.getDefenderFormation();
        final FormationGroup middlefieldFormation = teamFormation.getMiddlefieldFormation();
        final FormationGroup attackerFormation = teamFormation.getAttackerFormation();
        Array<OrganizedParameters> array = new Array<OrganizedParameters>();

        for (PlayerPosition pp : defenderFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, -1);
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        for (PlayerPosition pp : middlefieldFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, -1);
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        for (PlayerPosition pp : attackerFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, -1);
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        return array;
    }

    //TODO fix mult
    private Vector2 getPosition(PlayerPosition pp, FormationOrganizerType type, float leftOrRight) {
        final Vector2 ip = new Vector2(pp.getInitialPosition().x * leftOrRight, pp.getInitialPosition().y);
        System.out.println(ip);
        return ip;
    }

    public enum FormationOrganizerType {
        RANDOM, FIXED
    }

}
