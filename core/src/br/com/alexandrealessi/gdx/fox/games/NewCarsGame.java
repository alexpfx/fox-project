package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.entities.MovableEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.Stage;
import br.com.alexandrealessi.gdx.fox.base.utils.RequestHandler;

/**
 * Created by alex on 01/05/2015.
 */
public class NewCarsGame extends BaseGame {

    private Stage defaultStage = new Stage() {
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            addEntity(new MovableEntity() {
                @Override
                public void update(float delta) {

                }

                @Override
                public void dispose() {

                }
            });
            return true;
        }
    };
    protected NewCarsGame(RequestHandler requestHand) {
        super(requestHand);
    }

    @Override
    public void render() {
        defaultStage.render();
    }
}
