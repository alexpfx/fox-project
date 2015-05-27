package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.WorldComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 24/05/15.
 */
public class RenderSystem extends EntitySystem {

    private final boolean debugPhysics;
    private ImmutableArray<Entity> players;
    private Entity worldEntity;

    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<WorldComponent> wm = ComponentMapper.getFor(WorldComponent.class);

    private SpriteBatch batch;
    private Camera camera;
    private Box2DDebugRenderer box2DDebugRenderer;

    public RenderSystem(Viewport viewport, boolean debugPhysics) {
        this.debugPhysics = debugPhysics;
        batch = new SpriteBatch();
        camera = viewport.getCamera();
        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void addedToEngine(Engine engine) {
        players = engine
                .getEntitiesFor(Family.all(BodyComponent.class, PositionComponent.class, SpriteComponent.class).get());

        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).get(0);

    }

    @Override
    public void update(float deltaTime) {
        camera.update();
        renderSprites();
        renderWorld();

    }

    private void renderWorld() {
        if (debugPhysics){
            final World world = wm.get(worldEntity).getWorld();
            box2DDebugRenderer.render(world, camera.combined);
        }
    }

    private void renderSprites() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int i = 0; i < players.size(); i++) {
            final Entity e = players.get(i);
            final PositionComponent positionComponent = pm.get(e);
            final SpriteComponent spriteComponent = sm.get(e);
            final Sprite sprite = spriteComponent.getSprite();
            sprite.setPosition(positionComponent.getX() - sprite.getWidth() * 0.5f, positionComponent.getY() - sprite
                    .getHeight() * 0.5f);
            sprite.setRotation(positionComponent.getRotation());
            sprite.setOriginCenter();
            sprite.draw(batch, 1f);
        }
        batch.end();
    }

}
