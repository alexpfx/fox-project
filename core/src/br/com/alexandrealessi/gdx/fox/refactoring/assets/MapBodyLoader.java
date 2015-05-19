package br.com.alexandrealessi.gdx.fox.refactoring.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Logger;
import com.cookbook.box2d.MapBodyManager;

/**
 * Created by alexandre on 18/05/15.
 */
public class MapBodyLoader {

    private static final float SCREEN_TO_WORLD = 30F;
    private static final float WORLD_TO_SCREEN = 1/SCREEN_TO_WORLD;
    private static final float SCENE_WIDTH = 12.8F;
    private static final float SCENE_HEIGHT = 7.2F;

    private MapBodyManager mapBodyManager;
    private TmxMapLoader loader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;

    public MapBodyLoader(World world) {
        this.world = world;
    }

    public void create (){
        loader = new TmxMapLoader();
        map = loader.load("tiled_example.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, WORLD_TO_SCREEN);
        mapBodyManager = new MapBodyManager(world, SCREEN_TO_WORLD, Gdx.files.internal("materials.json"), Logger.INFO);
        mapBodyManager.createPhysics(map);
    }

}
