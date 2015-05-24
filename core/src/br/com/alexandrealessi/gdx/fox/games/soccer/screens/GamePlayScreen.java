package br.com.alexandrealessi.gdx.fox.games.soccer.screens;

import br.com.alexandrealessi.gdx.fox.base.screens.Screen;
import br.com.alexandrealessi.gdx.fox.games.soccer.SoccerGame;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.PositionComponent;
import br.com.alexandrealessi.gdx.fox.games.soccer.components.SpriteComponent;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by alexandre on 23/05/15.
 */
public class GamePlayScreen extends Screen {

    private Engine engine;
    private Entity entity;
    private TextureAtlas atlas;

    public GamePlayScreen(SoccerGame game) {
        super(game);
        atlas = new TextureAtlas(Gdx.files.internal("data/images/game.atlas"));
        createEngine ();
    }

    private void createEngine() {
        engine = new Engine();
        entity = new Entity();
        entity.add(new PositionComponent());
        entity.add(new SpriteComponent(new Sprite(atlas.findRegion("monkey"))));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }
}
