package br.com.alexandrealessi.gdx.fox.games.race.entities.cars;

/**
 * Created by alex on 02/05/2015.
 */
//TODO: car nao eh Physcal nem Visual entity ja q nao tem corpo nem figura que represente.

public class Car implements Accelerable {

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
        rearWheel.accelerate(amount, direction);


//        if ((chassis.getPhysicalAngle() % Math.PI) < (Math.PI / 6) && (chassis.getPhysicalAngle() % Math.PI) > (5 * Math.PI / 6)){
//            chassis.applyAngularImpulse(.1f, -direction);
//        }
        System.out.println(chassis.getPhysicalAngle());;


    }

    @Override
    public void brek(float amount) {
    }

    //angular: 94 rad/sec
    //radius: 0.3
    //CIRC: = 2Pi R = 2 * 3.14 * 0.3 = 1.884 m



    public float getKmh() {
        final float radius = frontWheel.getRadius();
        final float angularVelocity = frontWheel.getAngularVelocity() ;


        return angularVelocity * radius / 1000 * 3600;
    }
}
