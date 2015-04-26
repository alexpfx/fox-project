package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointEdge;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.uwsoft.editor.renderer.script.IScript;

/**
 * Created by alexandre on 25/04/15.
 */
public class CarController implements IScript {
    private CompositeItem item;
    ImageItem chassi;
    ImageItem rodaDianteira;
    ImageItem rodaTraseira;
    final float WORLD_TO_SCREEN = 31.5f;
    private WheelJoint eixoDianteiro;
    private Body chassiBody;

    @Override
    public void init(CompositeItem item) {
        this.item = item;
        chassi = item.getImageById("chassi");
        chassiBody = chassi.getBody();

        rodaDianteira = item.getImageById("rodaDianteira");
        rodaTraseira = item.getImageById("rodaTraseira");


        eixoDianteiro = (WheelJoint) chassiBody.getJointList().get(0).joint;
        eixoDianteiro.enableMotor(true);


    }

    @Override
    public void dispose() {

    }

    @Override
    public void act(float delta) {

        System.out.println(chassi.getWidth());
        float x = chassiBody.getPosition().x * WORLD_TO_SCREEN + 400 - (chassi.getWidth() / 2);
        float y = chassiBody.getPosition().y * WORLD_TO_SCREEN + 240 - (chassi.getHeight() / 2);
        float r = chassiBody.getAngle() * MathUtils.radDeg;

        chassi.setOrigin(Align.center);
        chassi.setPosition(x, y);
        chassi.setRotation(r);

        final Body rodaDianteiraBody = rodaDianteira.getBody();
        x = rodaDianteiraBody.getPosition().x * WORLD_TO_SCREEN + 400 - (rodaDianteira.getWidth() / 2);
        y = rodaDianteiraBody.getPosition().y * WORLD_TO_SCREEN + 240 - (rodaDianteira.getHeight() / 2);
        r = rodaDianteiraBody.getAngle() * MathUtils.radDeg;

        rodaDianteira.setPosition(x, y);
        rodaDianteira.setOrigin(Align.center);
        rodaDianteira.setRotation(r);


        final Body rodaTraseiraBody = rodaTraseira.getBody();
        x = rodaTraseiraBody.getPosition().x * WORLD_TO_SCREEN + 400 - (rodaTraseira.getWidth() / 2);
        y = rodaTraseiraBody.getPosition().y * WORLD_TO_SCREEN + 240 - (rodaTraseira.getHeight() / 2);
        r = rodaTraseiraBody.getAngle() * MathUtils.radDeg;

        rodaTraseira.setPosition(x, y);
        rodaTraseira.setOrigin(Align.center);
        rodaTraseira.setRotation(r);

        eixoDianteiro.setMaxMotorTorque(100);



    }


    public void accelerate (){
        System.out.println("accel");
        eixoDianteiro.enableMotor(true);
        eixoDianteiro.setMotorSpeed((motorSpeed += 1) * -1);

//        eixoDianteiro.getBodyA().getWorld().setGravity(Vector2.X.set(0,-50));

    }

    public void stop (){
//        eixoDianteiro.enableMotor(false);
        eixoDianteiro.enableMotor(false);
        motorSpeed = 0;
//        eixoDianteiro.getBodyA().getWorld().setGravity(Vector2.X.set(0, -10));
    }


    float motorSpeed = 0;

    public void desaccelarete ( ){
        eixoDianteiro.enableMotor(true);
        eixoDianteiro.setMotorSpeed((motorSpeed += 1));

    }

}
