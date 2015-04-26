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
 * All Rube operations happens here to minimize dependency.
 */
public class RubeSceneWrapper {
    private final RubeScene scene;

    public RubeSceneWrapper(RubeScene scene) {
        this.scene = scene;
    }

    public Body getBody(String name) {
        return getBodies(name).get(0);
    }

    public Texture getTexture(String name) {
        return getTextures(name).get(0);
    }

    public Array<Body> getBodies(String name) {
        return scene.getNamed(Body.class, name);
    }

    public Array<Texture> getTextures(String name) {
        final Array<RubeImage> rubeImages = scene.getNamed(RubeImage.class, name);
        final Array<Texture> textures = new Array<Texture>();
        for (RubeImage image : rubeImages) {
            Texture t = new Texture(Gdx.files.internal(image.name));
            textures.add(t);
        }
        return textures;
    }

    public World getWorld (){
        return scene.getWorld();
    }
}
