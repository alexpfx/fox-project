package br.com.alexandrealessi.gdx.fox.base.box2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gushikustudios.rube.RubeDefaults;
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
        return getBodies(name).first();
    }



    public Fixture getFixture (Body body, String fixtureName){
        final Array<Fixture> fixturesByName = getFixturesByName(fixtureName);
        for (Fixture f:fixturesByName){
            if (body.equals(f.getBody())){
                return f;
            }
        }
        return null;
    }


    public Fixture getFixture (String name){
        return getFixturesByName(name).first();
    }
    public Array<Fixture> getFixturesByName(String name) {
        final Array named = scene.getNamed(Object.class, name);
        final Array <Fixture> fixtures = new Array<Fixture>();
        for (Object f:named){
            if (f instanceof Fixture){
                fixtures.add((Fixture) f);
            }
        }
        return fixtures;
    }

    public Array<Body> getBodies(String name) {
        return scene.getNamed(Body.class, name);
    }

    public World getWorld() {
        return scene.getWorld();
    }

}
