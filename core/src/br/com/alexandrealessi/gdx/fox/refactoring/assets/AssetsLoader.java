package br.com.alexandrealessi.gdx.fox.refactoring.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by alexandre on 17/05/15.
 */
public class AssetsLoader implements Disposable, AssetErrorListener{
    public static final String tag = AssetsLoader.class.getName();

    private AssetManager manager;

    public AssetsLoader() {
        manager = new AssetManager( );

    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {

    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
