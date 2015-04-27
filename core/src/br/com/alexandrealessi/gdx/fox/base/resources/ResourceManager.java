package br.com.alexandrealessi.gdx.fox.base.resources;

import br.com.alexandrealessi.gdx.fox.base.resources.exceptions.AssetsNotLoadedException;
import br.com.alexandrealessi.gdx.fox.base.resources.exceptions.WrongAtlasNameException;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandre on 23/04/15.
 */
public class ResourceManager {

    private AssetConfig assetConfig;
    private AssetManager manager;
    private Map<String, TextureAtlas> atlasMap;
    private boolean loaded = false;

    public ResourceManager(AssetConfig assetConfig) {
        this.assetConfig = assetConfig;
        this.manager = new AssetManager();
        atlasMap = new HashMap(16);
    }

    public void load() {
        loadGraphics();
    }

    private void loadGraphics() {
        for (String atlasFile : assetConfig.getAtlasFilePaths()) {
            manager.load(atlasFile, TextureAtlas.class);
        }
        manager.finishLoading();
        loaded = true;
        storeAtlas();
    }

    private void storeAtlas() {
        for (String atlasFile : assetConfig.getAtlasFilePaths()) {
            atlasMap.put(atlasFile, manager.get(atlasFile, TextureAtlas.class));
        }
    }

    public TextureRegion getRegion(String atlasName, String regionName) {
        if (!loaded) {
            throw new AssetsNotLoadedException();
        }

        final TextureAtlas atlas = atlasMap.get(assetConfig.getGraphicDirectory() + atlasName);

        if (atlas == null) {
            throw new WrongAtlasNameException();
        }
        return atlas.findRegion(regionName);
    }

}
