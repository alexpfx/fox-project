package br.com.alexandrealessi.gdx.fox.games.race.stages;

import br.com.alexandrealessi.gdx.fox.base.resources.AssetConfig;
import br.com.alexandrealessi.gdx.fox.games.race.stages.constants.ResourceConstants;

/**
 * Created by alexandre on 26/04/15.
 */
public class DefaultStageAssetConfig extends AssetConfig {

    @Override
    public String getAssetBaseDirectory() {
        return "car";
    }

    @Override
    protected String[] getAtlasFileNames() {
        return new String[]{ResourceConstants.GAME_ATLAS_NAME.value/*, CarsGameConstants.Strings.GUI_ATLAS_NAME.value*/};
    }
}
