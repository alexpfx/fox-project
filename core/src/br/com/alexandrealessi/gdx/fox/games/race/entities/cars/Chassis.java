package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;

/**
 * Created by alex on 02/05/2015.
 */

public class Chassis extends DefaultEntity {

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_chassis")
    @BodyName(bodyNameReference = "peugeot_chassis")
    public Chassis() {


    }

}
