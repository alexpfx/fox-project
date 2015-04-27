package br.com.alexandrealessi.gdx.fox.car.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;

/**
 * Created by alexandre on 26/04/15.
 * All Rube operations happens here yTo minimize dependency.
 */
public class RubeSceneWrapper {
    private final RubeScene scene;

    public RubeSceneWrapper(RubeScene scene) {
        this.scene = scene;
    }

    public Body getBody(String name) {
        return getBodies(name).get(0);
    }

    public Array<Body> getBodies(String name) {
        return scene.getNamed(Body.class, name);
    }

    public String getBindedImageFileName (Body body){
        final Array<RubeImage> mappedImage = scene.getMappedImage(body);
        final RubeImage rubeImage = mappedImage.get(0);
        return rubeImage.name;
    }

    public World getWorld() {
        return scene.getWorld();
    }
}
