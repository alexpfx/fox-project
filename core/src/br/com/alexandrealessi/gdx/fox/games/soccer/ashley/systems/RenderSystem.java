package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PlayerMatchContextComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.SpriteComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components.WorldComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.ashley.utils.ComponentMappers;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 24/05/15.
 */
public class RenderSystem extends EntitySystem implements Disposable {

    private final boolean debugPhysics;
    private ImmutableArray<Entity> players;
    private Entity worldEntity;

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
                .getEntitiesFor(Family.all(PositionComponent.class, SpriteComponent.class).get());
        worldEntity = engine.getEntitiesFor(Family.one(WorldComponent.class).get()).get(0);
    }

    @Override
    public void update(float deltaTime) {
        camera.update();
        renderSprites();
        renderWorld();

    }

    private void renderWorld() {
        if (debugPhysics) {
            final World world = ComponentMappers.WORLD.get(worldEntity).getWorld();
            box2DDebugRenderer.render(world, camera.combined);
        }
    }

    private void renderSprites() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int i = 0; i < players.size(); i++) {
            final Entity e = players.get(i);
            final PositionComponent positionComponent = ComponentMappers.POSITION.get(e);
            final SpriteComponent spriteComponent = ComponentMappers.SPRITE_COMPONENT.get(e);
            final Sprite sprite = spriteComponent.getSprite();
            final PlayerMatchContextComponent playerMatchContextComponent = ComponentMappers.PLAYER_MATCH_CONTEXT.get(e);
            if (playerMatchContextComponent != null){
                if (playerMatchContextComponent.isSelected()){
                    sprite.setColor(Color.CYAN);
                }else{
                    sprite.setColor(Color.WHITE);
                }

            }
            sprite.setPosition(positionComponent.getPosition().x - sprite.getWidth() * 0.5f, positionComponent
                    .getPosition().y - sprite
                    .getHeight() * 0.5f);
            sprite.setRotation(positionComponent.getRotation());
            sprite.setOriginCenter();
            sprite.draw(batch, 1f);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        box2DDebugRenderer.dispose();
    }
}
