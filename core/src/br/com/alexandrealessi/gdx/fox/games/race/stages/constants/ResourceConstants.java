package br.com.alexandrealessi.gdx.fox.games.race.stages.constants;

/**
 * Created by alexandre on 02/05/15.
 */
public enum ResourceConstants {
    GAME_ATLAS_NAME("game.atlas"),
    GUI_ATLAS_NAME("gui.atlas");

    public final String value;

    private ResourceConstants(String value) {
        this.value = value;
    }
}
