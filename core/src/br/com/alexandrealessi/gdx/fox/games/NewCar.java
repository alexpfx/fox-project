package br.com.alexandrealessi.gdx.fox.games;

import br.com.alexandrealessi.gdx.fox.base.components.Drawable;
import br.com.alexandrealessi.gdx.fox.base.entities.BodyWrapper;
import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;

/**
 * Created by alex on 02/05/2015.
 */
public abstract class NewCar extends DefaultEntity {


    public NewCar() {


    }

    abstract Wheel getFrontWheel ();
    abstract Wheel getRearWheel ();
    abstract Chassis getChassis ();


//    private Wheel frontWheel;
//    private Wheel rearWheel;
//    private Chassis chassis;

}
