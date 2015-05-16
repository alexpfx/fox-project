package br.com.alexandrealessi.gdx.fox.games.topdown.stages;

import br.com.alexandrealessi.gdx.fox.games.topdown.stages.constants.ResourceConstants;

/**
 * Created by alexandre on 26/04/15.
 */
public class DefaultAssetConfig extends br.com.alexandrealessi.gdx.fox.base.resources.AssetConfig {

    @Override
    public String getAssetBaseDirectory() {
        return "topdownrace";
    }

    @Override
    protected String[] getAtlasFileNames() {
        return new String[]{ResourceConstants.GAME_ATLAS_NAME.value/*, CarsGameConstants.Strings.GUI_ATLAS_NAME.value*/};
    }
}
