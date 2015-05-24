package br.com.alexandrealessi.gdx.fox.base.screens;

import com.badlogic.gdx.Game;

/**
 * Created by alexandre on 24/05/15.
 */
public class Screen implements com.badlogic.gdx.Screen {
    private Game game;


    public Screen (Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
