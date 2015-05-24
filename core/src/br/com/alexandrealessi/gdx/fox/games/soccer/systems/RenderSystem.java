package br.com.alexandrealessi.gdx.fox.games.soccer.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.SpriteComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexandre on 24/05/15.
 */
public class RenderSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);

    public RenderSystem(OrthographicCamera camera) {
        batch = new SpriteBatch();
        this.camera = camera;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, SpriteComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        camera.update();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        for (int i = 0; i < entities.size(); i++) {
            final Entity e = entities.get(i);
            final PositionComponent positionComponent = pm.get(e);
            final SpriteComponent spriteComponent = sm.get(e);
            final Sprite sprite = spriteComponent.getSprite();
            sprite.setPosition(positionComponent.getX(), positionComponent.getY());
            sprite.setRotation(positionComponent.getRotation());
            sprite.draw(batch);
        }
        batch.end();

    }
}
