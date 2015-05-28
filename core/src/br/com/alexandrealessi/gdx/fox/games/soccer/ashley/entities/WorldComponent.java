package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 27/05/15.
 */
public class WorldComponent extends Component implements Disposable{
    private World world;

    public WorldComponent(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
