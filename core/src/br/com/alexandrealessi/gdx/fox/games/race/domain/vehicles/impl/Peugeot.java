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

    protected Peugeot() {
        super(new Chassis(new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return null;
            }

            @Override
            public String drawableName() {
                return null;
            }
        }), new FrontWheel(new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return null;
            }

            @Override
            public String drawableName() {
                return null;
            }
        }), new RearWheel(new ComponentDescriptor() {
            @Override
            public String bodyName() {
                return null;
            }

            @Override
            public String drawableName() {
                return null;
            }
        }));
    }
}
