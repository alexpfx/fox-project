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
            if (x < 100) return;
            final Fixture fixtureA = contact.getFixtureA();
            final Fixture fixtureB = contact.getFixtureB();
            if (!fixtureA.isSensor() && !fixtureB.isSensor())
                return;

            final Body bodyA = fixtureA.getBody();
            final Body bodyB = fixtureB.getBody();
            final Player playerA = (Player) bodyA.getUserData();
            final Player playerB = (Player) bodyB.getUserData();
            if (playerA == null || playerB == null)
                return;



            final String name = (String) fixtureA.getUserData();

            float ra = MathUtils.random(10f);
            float rb = MathUtils.random(10f);
            float d = ra - rb;
            if (d > 1){
                playerA.add();
                if (MathUtils.randomBoolean(0.5f))
                    playerB.sub();
                System.out.println(playerB.getContacts());
            } else if (d < -1){
                playerB.add();
                if (MathUtils.randomBoolean(0.5f))
                    playerA.sub();
                System.out.println(playerA.getContacts());
            }



            int limit = 1;

            if (playerA.reached(limit)){
                System.out.println("morto: "+playerA.getName());
                deleteIt.add(bodyA);
            }
            if (playerB.reached(limit)){
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


    int x = 0;
    @Override
    public void update(float deltaTime) {
        final Camera camera = viewport.getCamera();
        camera.update();
        if (debugPhysics){
            debugRenderer.render(world, camera.combined);
        }
        if (deleteIt.size > 0){
            for (Body b:deleteIt){
                b.setActive(false);
                world.destroyBody(b);
            }

            deleteIt.clear();
        }

        if ((x ++ % 300) == 0){
            Array<Body> bs = new Array<Body>();
            world.getBodies(bs);
            System.out.println();
            for (Body b: bs){
                final Object userData = b.getUserData();

                if (userData != null && userData instanceof Player){
                    System.out.println("Vivo ainda: "+((Player) userData).getName());
                }
            }
            System.out.println();

        }

        if (MathUtils.randomBoolean(0.05f)){
            Array<Body> bs = new Array<Body>();
            world.getBodies(bs);
            if (bs.size > 0){
                bs.get(MathUtils.random(bs.size - 1)).applyLinearImpulse(100, -100, 5, 5, true);
            }
        }

        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }



}
