package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl;

import br.com.alexandrealessi.gdx.fox.base.components.ComponentDescriptor;

/**
 * Created by alexandre on 26/04/15.
 */
public final class FrontWheel implements VehicleComponent {

    private final ComponentDescriptor descriptor;

    public FrontWheel(ComponentDescriptor descriptor) {

        this.descriptor = descriptor;
    }

    @Override
    public ComponentDescriptor getDescriptor() {
        return descriptor;
    }
}
