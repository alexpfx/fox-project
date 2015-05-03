package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;

/**
 * Created by alexandre on 26/04/15.
 * All Rube operations happens here to minimize dependency.
 */
public class RubeSceneWrapper {
    private final RubeScene scene;

    public RubeSceneWrapper(String sceneFile, World world) {
        RubeSceneLoader loader = new RubeSceneLoader(world);
        scene = loader.loadScene(Gdx.files.internal(sceneFile));
    }

    public Body getBody(String name) {
        return getBodies(name).get(0);
    }

    public Array<Body> getBodies(String name) {
        return scene.getNamed(Body.class, name);
    }

    public String getBindedImageFileName(Body body) {
        final Array<RubeImage> mappedImage = scene.getMappedImage(body);
        final RubeImage rubeImage = mappedImage.get(0);
        return rubeImage.name;
    }

    public World getWorld() {
        return scene.getWorld();
    }


    public Joint getJoint (String name){
        return scene.getNamed(Joint.class, name).get(0);
    }


}
