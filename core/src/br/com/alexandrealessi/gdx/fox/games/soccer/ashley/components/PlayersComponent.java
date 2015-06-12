package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 12/06/15.
 */
public class PlayersComponent extends Component{

    private Array <Entity> entities;

    public PlayersComponent (Array<Entity> players){
        this.entities = players;
    }

    public Array<Entity> getEntities() {
        return entities;
    }
}
