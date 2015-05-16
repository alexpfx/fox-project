package br.com.alexandrealessi.gdx.fox.games.topdown.stages.constants;

/**
 * Created by alexandre on 16/05/15.
 */
public enum ResourceConstants {
    GAME_ATLAS_NAME("topdown.atlas"),
    GUI_ATLAS_NAME("gui.atlas");

    public final String value;

    private ResourceConstants(String value) {
        this.value = value;
    }
}
