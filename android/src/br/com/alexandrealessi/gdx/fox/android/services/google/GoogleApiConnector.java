package br.com.alexandrealessi.gdx.fox.android.services.google;

import android.content.Context;
import android.os.Bundle;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncher;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncherView;
import br.com.alexandrealessi.gdx.fox.android.services.google.services.common.ApiConnector;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;

/**
 * Created by alexandre on 16/04/15.
 */
public class GoogleApiConnector implements ApiConnector, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleApiClient;
    private AndroidLauncherView view;

    public GoogleApiConnector(AndroidLauncher androidLauncher) {
        view = (AndroidLauncherView) view;
        mGoogleApiClient = new GoogleApiClient.Builder(androidLauncher.getApplicationContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES).build();

    }

    @Override
    public void onConnected(Bundle bundle) {
        view.showConnected();
    }

    @Override
    public void onConnectionSuspended(int i) {
        view.showConnectionSuspended();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        view.showConnectionFailed();
    }

    @Override
    public void onStart() {
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        mGoogleApiClient.disconnect();

    }
}
