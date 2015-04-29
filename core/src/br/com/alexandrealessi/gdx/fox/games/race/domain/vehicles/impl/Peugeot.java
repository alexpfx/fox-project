package br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.impl;

import br.com.alexandrealessi.gdx.fox.base.components.ComponentDescriptor;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.Car;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.Chassis;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.FrontWheel;
import br.com.alexandrealessi.gdx.fox.games.race.domain.vehicles.components.impl.RearWheel;

/**
 * Created by alexandre on 27/04/15.
 */
public class Peugeot extends Car {

    public static final String rearWheel = "peugeot_rear_wheel";
    public static final String frontWheel = "peugeot_front_wheel";
    private static String chassis = "peugeot_chassis";

    private Peugeot(Chassis c, FrontWheel f, RearWheel r) {
        super(c, f, r);
    }

    public static Peugeot createPeugeot() {
        final ComponentDescriptor cdc = new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return chassis;
            }

            @Override
            public String drawableName() {
                return null;
            }
        };

        ComponentDescriptor cdf = new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return frontWheel;
            }

            @Override
            public String drawableName() {
                return null;
            }
        };

        ComponentDescriptor cdr = new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return rearWheel;
            }

            @Override
            public String drawableName() {
                return null;
            }
        };
        return new Peugeot(new Chassis(cdc), new FrontWheel(cdf), new RearWheel(cdr));
    }

}
