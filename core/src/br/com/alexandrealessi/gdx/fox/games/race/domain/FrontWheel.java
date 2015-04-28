package br.com.alexandrealessi.gdx.fox.games.race.domain;

/**
 * Created by alexandre on 26/04/15.
 */
public final class FrontWheel implements VehicleComponent {

    private final String bodyName;
    private final String drawableName;

    public FrontWheel(String bodyName, String drawableName) {

        this.bodyName = bodyName;
        this.drawableName = drawableName;
    }

    @Override
    public String getDrawableName() {
        return drawableName;
    }

    @Override
    public String getBodyName() {
        return bodyName;
    }
}
