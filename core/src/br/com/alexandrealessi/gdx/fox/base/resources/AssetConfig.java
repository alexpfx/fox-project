package br.com.alexandrealessi.gdx.fox.base.resources;

/**
 * Created by alexandre on 23/04/15.
 */
public abstract class AssetConfig {

    public static final String FONTS = "/fonts/";
    public static final String IMAGES = "/images/";
    public static final String SOUNDS = "/sounds/";

    public abstract String getAssetBaseDirectory();

    public String getFontDirectory() {
        return getAssetBaseDirectory() + FONTS;
    }

    public String getGraphicDirectory() {
        return getAssetBaseDirectory() + IMAGES;
    }

    public String getSoundDirectory() {
        return getAssetBaseDirectory() + SOUNDS;
    }

    /**
     * List of atlas files in graphics directory.
     * Override if you need more atlas files.
     *
     * @return
     */
    protected String[] getAtlasFileNames() {
        return new String[]{
                "game_textures.atlas"
        };
    }

    public String[] getAtlasFilePaths() {
        final String[] atlasFileNames = getAtlasFileNames();
        final String[] atlasFilesPaths = new String[atlasFileNames.length];
        int i = 0;
        for (String name : atlasFileNames) {
            atlasFilesPaths[i++] = getGraphicDirectory() + name;
        }
        return atlasFilesPaths;
    }
}
