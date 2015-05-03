package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.JointName;

/**
 * Created by alex on 02/05/2015.
 */
public class Car extends DefaultEntity implements Accelerable {

    private Chassis chassis;
    private Wheel frontWheel;
    private Wheel rearWheel;
    private Axis frontAxis;
    private Axis rearAxis;


    public Car() {
        chassis = new Chassis();
        frontWheel = new Wheel();
        rearWheel = new Wheel();
    }


    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_chassis")
    @BodyName(bodyNameReference = "peugeot_chassis")
    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_front_wheel")
    @BodyName(bodyNameReference = "peugeot_front_wheel")
    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public void setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_rear_wheel")
    @BodyName(bodyNameReference = "peugeot_rear_wheel")
    public Wheel getRearWheel() {
        return rearWheel;
    }

    public void setRearWheel(Wheel rearWheel) {
        this.rearWheel = rearWheel;
    }

    public Axis getFrontAxis() {
        return frontAxis;
    }

    @JointName(jointName = "peugeot_front_axis")
    public void setFrontAxis(Axis frontAxis) {
        this.frontAxis = frontAxis;
    }

    public Axis getRearAxis() {
        return rearAxis;
    }

    @JointName(jointName = "peugeot_rear_axis")
    public void setRearAxis(Axis rearAxis) {
        this.rearAxis = rearAxis;
    }

    @Override
    public void accelerate(float amount, float target) {
        frontAxis.accelerate(amount, target);
        rearAxis.accelerate(amount, target);
    }

    @Override
    public void brek(float amount) {
        frontAxis.brek(amount);
        rearAxis.brek(amount);
    }
}
