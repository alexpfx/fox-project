package br.com.alexandrealessi.gdx.fox.base.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.ai.steer.SteeringBehavior;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alexandre on 24/05/15.
 */
public class BodyComponent extends Component {
    boolean tagged;
    float maxLinearSpeed;
    float maxLinearAcceleration;
    float maxAngularSpeed;
    float maxAngularAcceleration;
    private Body body;
    private float boundigRadius;
    private SteeringBehavior<Vector2> steeringBehavior;

    public BodyComponent(Body body, float boundigRadius) {
        this.body = body;
        this.boundigRadius = boundigRadius;
        tagged = false;
    }

    public BodyComponent(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

}
