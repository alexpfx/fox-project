package br.com.alexandrealessi.gdx.fox.base.utils.box2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;

/**
 * Created by alexandre on 26/04/15.
 */
public class RubeSceneHelper {
    private final RubeScene scene;

    public RubeSceneHelper(String sceneFile, World world) {
        RubeSceneLoader loader = new RubeSceneLoader(world);
        scene = loader.loadScene(Gdx.files.internal(sceneFile));
    }

    public RubeSceneHelper(String sceneFile) {
        this(sceneFile, null);
    }

    public Body getBody(String name) {
        return getBodies(name).get(0);
    }

    public Array<Fixture> getFixturesByName(String name) {
        return scene.getNamed(Fixture.class, name);
    }

    public Array<Body> getBodies(String name) {
        return scene.getNamed(Body.class, name);
    }

    public World getWorld() {
        return scene.getWorld();
    }

}
