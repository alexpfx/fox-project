package br.com.alexandrealessi.gdx.fox.games.soccer.domain.team;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alexandre on 10/06/15.
 */
public class FormationOrganizer {

    private PlayerPosition playerPosition;
    private Array<Vector2> positionArray;
    private float scale = 0;

    public FormationOrganizer(PlayerPosition playerPosition, Array<Vector2> positionArray, float scale) {
        this.playerPosition = playerPosition;
        this.positionArray = positionArray;
        this.scale = scale;
    }

    public Array.ArrayIterator <Vector2> getIterator (){
        return (Array.ArrayIterator<Vector2>) positionArray.iterator();
    }

}
