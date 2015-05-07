package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

import br.com.alexandrealessi.gdx.fox.base.entities.*;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyName;
import br.com.alexandrealessi.gdx.fox.base.entities.utils.DrawableName;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import java.lang.reflect.Field;

/**
 * Created by alex on 02/05/2015.
 */
//TODO: car nao eh Physcal nem Visual entity ja q nao tem corpo nem figura que represente.

public class Car implements Accelerable, Entity {

    private Chassis chassis;
    private Wheel frontWheel;
    private Wheel rearWheel;

    public Car(Chassis chassis, Wheel front, Wheel rear) {
        this.chassis = chassis;
        this.frontWheel = front;
        this.rearWheel = rear;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public void setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
    }


    public Wheel getRearWheel() {
        return rearWheel;
    }

    public void setRearWheel(Wheel rearWheel) {
        this.rearWheel = rearWheel;
    }

    @Override
    public void accelerate(float amount, float direction) {
        frontWheel.accelerate(amount, direction);
//        rearWheel.accelerate(amount,direction);
    }

    @Override
    public void brek(float amount) {
    }


}
