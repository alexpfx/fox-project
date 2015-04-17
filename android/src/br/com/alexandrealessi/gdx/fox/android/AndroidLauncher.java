package br.com.alexandrealessi.gdx.fox.android;

import android.os.Bundle;

import android.widget.Toast;
import br.com.alexandrealessi.gdx.fox.android.services.google.GoogleApiLeaderboards;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import br.com.alexandrealessi.gdx.fox.MainGame;

public class AndroidLauncher extends AndroidApplication implements AndroidLauncherView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        final MainGame mainGame = new MainGame(new GoogleApiLeaderboards());
        initialize(mainGame, config);
        /*
		Important: Because it is hard to anticipate the state of each device, you must always check for a
		compatible Google Play services APK before you access Google Play services features.
		 */
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    //
    @Override
    public void showConnected() {
        Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT);
    }

    @Override
    public void showConnectionSuspended() {
        Toast.makeText(getApplicationContext(), "Connection was Suspended", Toast.LENGTH_SHORT);

    }

    @Override
    public void showConnectionFailed() {
        Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT);

    }
}
