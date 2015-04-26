package br.com.alexandrealessi.gdx.fox.overlapexample;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
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

    @Override
    public void init(CompositeItem item) {
        this.item = item;
        chassi = item.getImageById("chassi");
        rodaDianteira = item.getImageById("rodaDianteira");
        rodaTraseira = item.getImageById("rodaTraseira");
    }

    @Override
    public void dispose() {

    }

    @Override
    public void act(float delta) {
        final Body chassiBody = chassi.getBody();
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


//        final float x = chassiBody.getPosition().x * WORLD_TO_SCREEN + 400 - (item.getWidth() / 2 ) ;
//        final float y = chassiBody.getPosition().y * WORLD_TO_SCREEN + 240 - (item.getHeight() / 2) ;

    }
}
