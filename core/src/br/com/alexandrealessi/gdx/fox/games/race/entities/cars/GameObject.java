package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.RigidBody;

/**
 * Created by alexandre on 06/05/15.
 */
public abstract class GameObject {

    protected RigidBody body;

    public GameObject(RigidBody body) {
        this.body = body;
    }

    public void update (){
        body.update();
    }

}
