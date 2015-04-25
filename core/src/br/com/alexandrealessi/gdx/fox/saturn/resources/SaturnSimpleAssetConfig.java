package br.com.alexandrealessi.gdx.fox.saturn.resources;

import br.com.alexandrealessi.gdx.fox.base.resources.AssetConfig;

/**
 * Created by alexandre on 23/04/15.
 */
public class SaturnSimpleAssetConfig extends AssetConfig {

    @Override
    public String getAssetBaseDirectory() {
        return "saturn";
    }

    @Override
    public String[] getAtlasFiles() {

        return new String[]{"game.atlas", "gui.atlas"};
    }
}
