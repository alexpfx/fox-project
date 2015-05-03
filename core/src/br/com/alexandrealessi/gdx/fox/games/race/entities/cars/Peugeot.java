package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.JointName;
import com.badlogic.gdx.physics.box2d.JointEdge;

/**
 * Created by alex on 02/05/2015.
 */
public class Peugeot extends Car {

    private Wheel frontWheel, rearWheel;
    private Chassis chassis;

    public Peugeot() {
        super(new Chassis(), new Wheel(), new Wheel());
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_front_wheel")
    @BodyName(bodyNameReference = "peugeot_front_wheel")
    @Override
    public Wheel getFrontWheel() {
        return frontWheel;
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_rear_wheel")
    @BodyName(bodyNameReference = "peugeot_rear_wheel")
    @Override
    public Wheel getRearWheel() {
        return rearWheel;
    }

    @DrawableName(atlasName = "game.atlas", drawableName = "peugeot_chassis")
    @BodyName(bodyNameReference = "peugeot_chassis")
    @Override
    public Chassis getChassis() {
        return chassis;
    }

    @Override
    public JointEdge getFrontAxis() {
        return frontAxis;
    }

    @Override
    public JointEdge getRearAxis() {
        return rearAxis;
    }

    @JointName(jointName = "peugeot_front_axis")
    @Override
    public void setFrontAxis(JointEdge frontAxis) {
        super.frontAxis = frontAxis;

    }

    @JointName(jointName = "peugeot_rear_axis")
    @Override
    public void setRearAxis(JointEdge rearAxis) {
        super.rearAxis = rearAxis;
    }
}
