package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.domain.TeamSide;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 10/06/15.
 */
public class FormationOrganizer {

    private final TeamFormation teamFormation;
    private final FormationOrganizerType type;
    private final TeamSide side;

    public FormationOrganizer(TeamFormation teamFormation,FormationOrganizerType organizationType, TeamSide side) {
        this.teamFormation = teamFormation;
        this.type = organizationType;
        this.side = side;
    }

    public Array<OrganizedParameters> organize() {
        final FormationGroup defenderFormation = teamFormation.getDefenderFormation();
        final FormationGroup middlefieldFormation = teamFormation.getMiddlefieldFormation();
        final FormationGroup attackerFormation = teamFormation.getAttackerFormation();
        Array<OrganizedParameters> array = new Array<OrganizedParameters>();

        for (PlayerPosition pp : defenderFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, side.getMultiplicator());
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        for (PlayerPosition pp : middlefieldFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, side.getMultiplicator());
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        for (PlayerPosition pp : attackerFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, side.getMultiplicator());
            array.add(OrganizedParameters.newInstance(position, pp));
        }
        return array;
    }

    private Vector2 getPosition(PlayerPosition pp, FormationOrganizerType type, float teamSide) {
        final Vector2 initialPosition = new Vector2(pp.getInitialPosition().x * teamSide, pp.getInitialPosition().y * teamSide);
        return initialPosition;
    }

    public enum FormationOrganizerType {
        RANDOM, FIXED
    }

}
