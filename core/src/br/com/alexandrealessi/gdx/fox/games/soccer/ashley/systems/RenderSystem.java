package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.systems;

import br.com.alexandrealessi.gdx.fox.base.ashley.components.BodyComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.base.ashley.components.SpriteComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 24/05/15.
 */
public class RenderSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;
    private SpriteBatch batch;
    private Viewport viewport;
    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);

    public RenderSystem(Viewport viewport) {
        batch = new SpriteBatch();
        this.viewport = viewport;

    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(BodyComponent.class, PositionComponent.class, SpriteComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        viewport.getCamera().update();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        for (int i = 0; i < entities.size(); i++) {
            final Entity e = entities.get(i);
            final PositionComponent positionComponent = pm.get(e);
            final SpriteComponent spriteComponent = sm.get(e);
            final Sprite sprite = spriteComponent.getSprite();
            sprite.setPosition(positionComponent.getX() - sprite.getWidth() * 0.5f, positionComponent.getY() - sprite.getHeight() * 0.5f);
            sprite.setRotation(positionComponent.getRotation());
            sprite.setOriginCenter();
            sprite.draw(batch, 1f);
        }
        batch.end();
    }
}
