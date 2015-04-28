package br.com.alexandrealessi.gdx.fox.games.race.domain;

/**
 * Created by alexandre on 26/04/15.
 */
public final class Chassis implements VehicleComponent {

    private final String bodyName;
    private final String imageName;

    public Chassis(String bodyName, String imageName) {

        this.bodyName = bodyName;
        this.imageName = imageName;
    }

    @Override
    public String getDrawableName() {
        return bodyName;
    }

    @Override
    public String getBodyName() {
        return imageName;
    }
}
