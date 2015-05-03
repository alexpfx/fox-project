package br.com.alexandrealessi.gdx.fox.base.entities;

import br.com.alexandrealessi.gdx.fox.base.entities.utils.BodyWrapper;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by alex on 02/05/2015.
 */
public interface PhysicalEntity extends Entity {
    void setBodyWrapper (Body bodyWrapper);
    Body getBodyWrapper ();
}
