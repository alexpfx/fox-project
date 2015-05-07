package br.com.alexandrealessi.gdx.fox.base.entities;

/**
 * Created by alexandre on 06/05/15.
 */
public interface PhysicObject {
    void update();
    public void applyAngularImpulse(float impule, boolean wake);
}
