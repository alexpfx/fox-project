package br.com.alexandrealessi.gdx.fox.base.utils;

/**
 * Created by alexandre on 19/04/15.
 */
public enum GameServicesKeys {

    LEADERBOARD_BEST_FOXES(""),
    ACHIEVEMENT_BABY_FOX(""),
    ACHIEVEMENT_KID_FOX(""),
    ACHIEVEMENT_BLUE_FOX(""),
    ACHIEVEMENT_BLACK_FOX(""),
    ACHIEVEMENT_GOLDEN_FOX("");

    public final String key;

    private GameServicesKeys(String key) {
        this.key = key;
    }

}
