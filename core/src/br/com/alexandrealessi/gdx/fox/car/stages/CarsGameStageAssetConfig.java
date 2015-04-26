package br.com.alexandrealessi.gdx.fox.car.stages;

import br.com.alexandrealessi.gdx.fox.base.resources.AssetConfig;
import br.com.alexandrealessi.gdx.fox.car.CarGameConstants;

/**
 * Created by alexandre on 26/04/15.
 */
public class CarsGameStageAssetConfig extends AssetConfig {

    @Override
    public String getAssetBaseDirectory() {
        return "car";
    }

    @Override
    protected String[] getAtlasFileNames() {
        return new String[]{CarGameConstants.Strings.GAME_ATLAS_NAME.value/*, CarGameConstants.Strings.GUI_ATLAS_NAME.value*/};
    }
}
