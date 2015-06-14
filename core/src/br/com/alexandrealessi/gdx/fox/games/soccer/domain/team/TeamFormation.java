package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

/**
 * Created by alexandre on 31/05/15.
 */
public enum TeamFormation {

    F442("4-4-2A", DefenderFormation.DEFAULT_4, MiddlefieldFormation.DEFAULT_4, AttackerFormation.DEFAULT_2),
    F433("4-3-3A", DefenderFormation.DEFAULT_4, MiddlefieldFormation.DEFAULT_3, AttackerFormation.DEFAULT_3);

    private String name;
    private DefenderFormation defenderFormation;
    private MiddlefieldFormation middlefieldFormation;
    private AttackerFormation attackerFormation;

    TeamFormation(String name, DefenderFormation defenderFormation, MiddlefieldFormation middlefieldFormation, AttackerFormation attackerFormation) {
        this.name = name;
        this.defenderFormation = defenderFormation;
        this.middlefieldFormation = middlefieldFormation;
        this.attackerFormation = attackerFormation;
    }

    public DefenderFormation getDefenderFormation() {
        return defenderFormation;
    }

    public MiddlefieldFormation getMiddlefieldFormation() {
        return middlefieldFormation;
    }

    public AttackerFormation getAttackerFormation() {
        return attackerFormation;
    }
}

