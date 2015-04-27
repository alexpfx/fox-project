package br.com.alexandrealessi.gdx.fox.games.race.actors;

/**
 * Created by alexandre on 27/04/15.
 */
public abstract class BaseVehicleComponent implements IVehicleComponent {

    private final String mappedBodyname;
    private final String mappedImageName;

    protected BaseVehicleComponent(String mappedBodyname, String mappedImageName) {
        this.mappedBodyname = mappedBodyname;
        this.mappedImageName = mappedImageName;
    }

    @Override
    public String getMappedImageName() {
        return mappedImageName;
    }

    @Override
    public String getMappedBodyName() {
        return mappedBodyname;
    }
}
