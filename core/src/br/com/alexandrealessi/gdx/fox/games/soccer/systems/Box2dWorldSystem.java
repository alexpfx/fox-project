package br.com.alexandrealessi.gdx.fox.games.soccer.systems;

import br.com.alexandrealessi.gdx.fox.games.soccer.entities.Player;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by alexandre on 24/05/15.
 */
public class Box2dWorldSystem extends EntitySystem{
    public static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 3;
    private static final int POSITION_ITERATIONS = 2;

    private final World world;
    private Box2DDebugRenderer debugRenderer;
    private static final boolean debugPhysics = true;
    private Viewport viewport;
    Array <Body> deleteIt = new Array<Body>();

    public Box2dWorldSystem (World world, Viewport viewport){
        this.world = world;
        this.viewport = viewport;
        debugRenderer = new Box2DDebugRenderer();
        world.setContactListener(contactListener);
    }

    private ContactListener contactListener = new ContactListener() {
        @Override
        public void beginContact(Contact contact) {
            final Body bodyA = contact.getFixtureA().getBody();
            final Body bodyB = contact.getFixtureB().getBody();


            final Player playerA = (Player) bodyA.getUserData();
            final Player playerB = (Player) bodyB.getUserData();



            if (playerA == null || playerB == null)
                return;
            playerA.add();
            playerB.add();


            if (playerA.reached(90)){
                System.out.println("morto: "+playerA.getName());
                deleteIt.add(bodyA);
            }
            if (playerB.reached(90)){
                System.out.println("morto: "+playerB.getName());
                deleteIt.add(bodyB);
            }

        }

        @Override
        public void endContact(Contact contact) {

        }

        @Override
        public void preSolve(Contact contact, Manifold oldManifold) {

        }

        @Override
        public void postSolve(Contact contact, ContactImpulse impulse) {

        }
    };


    @Override
    public void update(float deltaTime) {
        final Camera camera = viewport.getCamera();
        camera.update();
        if (debugPhysics){
            debugRenderer.render(world, camera.combined);
        }
        if (deleteIt.size > 0){
            for (Body b:deleteIt){
                world.destroyBody(b);
            }
            deleteIt.clear();
        }
        if (MathUtils.randomBoolean(0.05f)){
            Array<Body> bs = new Array<Body>();
            world.getBodies(bs);
            if (bs.size > 0){
                bs.get(MathUtils.random(bs.size - 1)).applyLinearImpulse(100,-100,5,5, true);
            }
        }

        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }



}
