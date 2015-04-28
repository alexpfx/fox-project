package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl;

import br.com.alexandrealessi.gdx.fox.base.components.ComponentDescriptor;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.VehicleComponent;

/**
 * Created by alexandre on 26/04/15.
 */
public final class Chassis implements VehicleComponent {

    private final ComponentDescriptor descriptor;

    public Chassis(ComponentDescriptor descriptor) {

        this.descriptor = descriptor;
    }

    @Override
    public final ComponentDescriptor getDescriptor() {
        return descriptor;
    }
}
