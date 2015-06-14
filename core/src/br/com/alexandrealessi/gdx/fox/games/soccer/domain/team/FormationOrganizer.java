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

        Vector2 gkPosition = getPosition(PlayerPosition.GK, type, side.getMultiplicator());
        array.add(OrganizedParameters.newInstance(gkPosition, PlayerPosition.GK));

        createSector(defenderFormation, array);
        createSector(middlefieldFormation, array);
        createSector(attackerFormation, array);
        return array;
    }

    private void createSector(FormationGroup defenderFormation, Array<OrganizedParameters> array) {
        for (PlayerPosition pp : defenderFormation.getPositionArray()) {
            Vector2 position = getPosition(pp, type, side.getMultiplicator());
            array.add(OrganizedParameters.newInstance(position, pp));
        }
    }

    private Vector2 getPosition(PlayerPosition pp, FormationOrganizerType type, float teamSide) {
        final Vector2 initialPosition = new Vector2(pp.getInitialPosition().x * teamSide, pp.getInitialPosition().y * teamSide);
        return initialPosition;
    }

    public enum FormationOrganizerType {
        RANDOM, FIXED
    }

}
