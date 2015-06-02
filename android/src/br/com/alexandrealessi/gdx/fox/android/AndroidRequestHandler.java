package br.com.alexandrealessi.gdx.fox.android;

import android.content.Context;
import br.com.alexandrealessi.gdx.fox.base.services.RequestHandler;

/**
 * Created by alexandre on 19/04/15.
 */
public class AndroidRequestHandler implements RequestHandler {

    private Context context;

    public AndroidRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void submitScore(String mappedKey, long score) {


    }

    @Override
    public void incrementAchievment(String mappedKey, int amount) {

    }

    @Override
    public void unlockAchievment(String mappedKey) {

    }

    @Override
    public void setPlusOneButtonVisible(boolean visible) {

    }
}
