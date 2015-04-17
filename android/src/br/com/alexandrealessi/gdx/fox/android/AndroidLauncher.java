package br.com.alexandrealessi.gdx.fox.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import br.com.alexandrealessi.gdx.fox.MainGame;
import br.com.alexandrealessi.gdx.fox.android.services.google.GoogleApiConnector;
import br.com.alexandrealessi.gdx.fox.android.services.google.GoogleApiLeaderboards;
import br.com.alexandrealessi.gdx.fox.android.services.google.services.common.ApiConnector;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication implements AndroidLauncherView {

    private ApiConnector googlePlayConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        final MainGame mainGame = new MainGame(new GoogleApiLeaderboards());
        initialize(mainGame, config);

        googlePlayConnector = new GoogleApiConnector(this);

        /*
        Important: Because it is hard to anticipate the state of each device, you must always check for a
		compatible Google Play services APK before you access Google Play services features.
		 */
    }

    @Override
    protected void onStart() {
        super.onStart();
        googlePlayConnector.connect();

    }

    @Override
    protected void onStop() {
        super.onStop();
        googlePlayConnector.disconnect();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /* Fazer de outra maneira, pois assim está com problema de coesão: */
        /* Fazer esta verificação na classe GoogleApiConnector*/
        if (requestCode == 9001) {
            Toast.makeText(getApplicationContext(), "resolveu", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showConnected() {
        Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showConnectionSuspended() {
        Toast.makeText(getApplicationContext(), "Connection was Suspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showConnectionFailed() {
        Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();

    }

}
