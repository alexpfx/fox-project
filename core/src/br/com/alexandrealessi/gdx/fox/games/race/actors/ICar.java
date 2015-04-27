package br.com.alexandrealessi.gdx.fox.games.race.actors;

/**
 * Created by alexandre on 27/04/15.
 */
public interface ICar extends IVehicle {

    IVehicleComponent getChassis();

    IVehicleComponent getRearWheel();

    IVehicleComponent getFrontWheel();

}
