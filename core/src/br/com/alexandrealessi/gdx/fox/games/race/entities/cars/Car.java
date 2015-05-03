package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.DefaultEntity;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointEdge;

/**
 * Created by alex on 02/05/2015.
 */
public abstract class Car extends DefaultEntity {

    private Chassis chassis;
    private Wheel frontWheel;
    private Wheel rearWheel;
    protected JointEdge frontAxis;
    protected JointEdge rearAxis;


    public Car(Chassis chassis, Wheel rearWheel, Wheel frontWheel) {
        this.chassis = chassis;
        this.rearWheel = rearWheel;
        this.frontWheel = frontWheel;
    }

    abstract Wheel getFrontWheel();

    abstract Wheel getRearWheel();

    abstract Chassis getChassis();

    abstract public JointEdge getFrontAxis();

    abstract public JointEdge getRearAxis();

    abstract public void setFrontAxis(JointEdge frontAxis);

    abstract public void setRearAxis(JointEdge rearAxis);
}
