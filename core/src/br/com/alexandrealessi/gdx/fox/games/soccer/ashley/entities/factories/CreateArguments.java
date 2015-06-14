package br.com.alexandrealessi.gdx.fox.games.soccer.ashley.entities.factories;

import com.badlogic.gdx.utils.ArrayMap;

/**
 * Created by alexandre on 08/06/15.
 */
public class CreateArguments {

    private ArrayMap<String, Object> arguments = new ArrayMap<String, Object>();

    public <T> void put(String key, T value) {
        arguments.put(key, value);
    }

    public <T> T get(String key) {
        return (T) arguments.get(key);
    }

    public <T> T get(String key, T defaultValue) {
        T t = (T) arguments.get(key);
        return (t == null ? defaultValue : t);
    }
}
