package br.com.alexandrealessi.gdx.fox.base.resources;

/**
 * Created by alexandre on 23/04/15.
 */
public abstract class AssetConfig {

    public static final String FONTS = "/fonts/";
    public static final String GRAPHICS = "/graphics/";
    public static final String SOUNDS = "/sounds/";

    public abstract String getAssetBaseDirectory();

    public String getFontDirectory() {
        return FONTS;
    }

    public String getGraphicDirectory() {
        return GRAPHICS;
    }

    public String getSoundDirectory() {
        return SOUNDS;
    }

    /**
     * List of atlas files in graphics directory.
     * Override if you need more atlas files.
     * @return
     */
    public String [] getAtlasFiles (){
        return new String [] {
            "game_texture.atlas"
        };
    }

}
