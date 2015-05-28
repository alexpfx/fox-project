package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.ai.steer.SteeringAcceleration;
import com.badlogic.gdx.ai.steer.SteeringBehavior;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 28/05/15.
 */
public class SteerComponent extends Component implements Steerable<Vector2>, Updatable {

    public static final float MARGIN = 0.0001f;
    private Body body;
    private float boundingRadius;
    private boolean tagged = false;
    private float maxLinearSpeed;
    private float maxLinearAcceleration;
    private float maxAngularSpeed;
    private float maxAngularAcceleration;
    private SteeringBehavior<Vector2> steeringBehavior;
    private SteeringAcceleration<Vector2> steeringOutput;
    private boolean independentFacing;

    public SteerComponent(Body body, boolean independentFacing) {
        this.body = body;
        steeringOutput = new SteeringAcceleration<Vector2>(new Vector2());
        this.independentFacing = independentFacing;
    }

    @Override
    public void update(float delta) {
        if (steeringBehavior != null) {
            steeringBehavior.calculateSteering(steeringOutput);
            applySteering(steeringOutput, delta);
        }
        //wrap arround
    }

    private void applySteering(SteeringAcceleration<Vector2> steeringOutput, float delta) {
        boolean anyAcceleration = false;
        anyAcceleration = updatePositionAndLinearVelocity(delta);
        if (isIndependentFacing()) {
            anyAcceleration = updateOrientationAndAngularVelocity(delta);
        } else {
            updateOrientationAndAngularVelocityIfNotIndependentFacing(delta);
        }
        if (anyAcceleration) {
            updateBodyIfAnyAcceleration(delta);
        }
    }

    private void updateBodyIfAnyAcceleration(float delta) {
        final Vector2 linearVelocity = body.getLinearVelocity();
        final float currentSpeedSquare = linearVelocity.len2();
        final float maxLinearSpeed = getMaxLinearSpeed();
        if (currentSpeedSquare > (maxLinearSpeed * maxLinearSpeed)) {
            body.setLinearVelocity(linearVelocity.scl((maxLinearSpeed / (float) Math.sqrt(currentSpeedSquare))));
        }
        clampAngularVelocity();
    }

    private void clampAngularVelocity() {
        final float maxAngularSpeed = getMaxAngularSpeed();
        body.setAngularVelocity(MathUtils.clamp(body.getAngularVelocity(), 0, getMaxAngularSpeed()));
    }

    private boolean updatePositionAndLinearVelocity(float delta) {
        if (!steeringOutput.linear.isZero()) {
            return false;
        }
        final Vector2 force = steeringOutput.linear.scl(delta);
        body.applyForceToCenter(force, true);
        return true;
    }

    private boolean updateOrientationAndAngularVelocity(float delta) {
        if (steeringOutput.angular == 0) {
            return false;
        }
        body.applyTorque(steeringOutput.angular * delta, true);
        return true;
    }

    private void updateOrientationAndAngularVelocityIfNotIndependentFacing(float delta) {
        final Vector2 linearVelocity = getLinearVelocity();
        if (linearVelocity.isZero(MARGIN)) {
            return;
        }
        float newOrientation = vectorToAngle(linearVelocity);
        body.setAngularVelocity((newOrientation - getAngularVelocity()) * delta);
        body.setTransform(body.getPosition(), newOrientation);
    }

    @Override
    public Vector2 getPosition() {
        return body.getPosition();
    }

    @Override
    public float getOrientation() {
        return body.getAngle();
    }

    @Override
    public Vector2 getLinearVelocity() {
        return body.getLinearVelocity();
    }

    @Override
    public float getAngularVelocity() {
        return body.getAngularVelocity();
    }

    @Override
    public float getBoundingRadius() {
        //confirmar
        return body.getFixtureList().get(0).getShape().getRadius();
    }

    @Override
    public boolean isTagged() {
        return tagged;
    }

    @Override
    public void setTagged(boolean tagged) {
        this.tagged = tagged;
    }

    @Override
    public Vector2 newVector() {
        return new Vector2();
    }

    @Override
    public float vectorToAngle(Vector2 vector) {
        //confirmar
        return vector.angle();
    }

    @Override
    public Vector2 angleToVector(Vector2 outVector, float angle) {
        return null;
    }

    @Override
    public float getMaxLinearSpeed() {
        return maxLinearSpeed;
    }

    @Override
    public void setMaxLinearSpeed(float maxLinearSpeed) {
        this.maxLinearSpeed = maxLinearSpeed;
    }

    @Override
    public float getMaxLinearAcceleration() {
        return maxLinearAcceleration;
    }

    @Override
    public void setMaxLinearAcceleration(float maxLinearAcceleration) {
        this.maxLinearAcceleration = maxLinearAcceleration;
    }

    @Override
    public float getMaxAngularSpeed() {
        return maxAngularSpeed;
    }

    @Override
    public void setMaxAngularSpeed(float maxAngularSpeed) {
        this.maxAngularSpeed = maxAngularSpeed;
    }

    @Override
    public float getMaxAngularAcceleration() {
        return maxAngularAcceleration;
    }

    @Override
    public void setMaxAngularAcceleration(float maxAngularAcceleration) {
        this.maxAngularAcceleration = maxAngularAcceleration;
    }

    public void setSteeringBehavior(SteeringBehavior<Vector2> steeringBehavior) {
        this.steeringBehavior = steeringBehavior;
    }

    public boolean isIndependentFacing() {
        return independentFacing;
    }

    public void setIndependentFacing(boolean independentFacing) {
        this.independentFacing = independentFacing;
    }

}
