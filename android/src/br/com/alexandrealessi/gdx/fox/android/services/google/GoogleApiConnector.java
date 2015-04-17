package br.com.alexandrealessi.gdx.fox.android.services.google;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncher;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncherView;
import br.com.alexandrealessi.gdx.fox.android.services.google.services.common.ApiConnector;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;
import com.google.example.games.basegameutils.GameHelper;

/**
 * Created by alexandre on 16/04/15.
 */
public class GoogleApiConnector implements ApiConnector, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
//    https://developers.google.com/games/services/checklist#improving_the_sign_in_experience_for_games
    private GoogleApiClient mGoogleApiClient;
    private AndroidLauncherView view;
    private Activity launcher;
    private GameHelper gameHelper;
    public static final int RC_SIGN_IN = 9001;

    public GoogleApiConnector(AndroidLauncher androidLauncher) {
        view = (AndroidLauncherView) androidLauncher;
        launcher = androidLauncher;
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
        if (connectionResult.hasResolution()){
//            BaseGameUtils.resolveConnectionFailure(launcher,mGoogleApiClient,connectionResult,RC_SIGN_IN,"error");
            try {
                connectionResult.startResolutionForResult(launcher, RC_SIGN_IN);
            } catch (IntentSender.SendIntentException e) {
                mGoogleApiClient.connect();
            }
        }
        else{
            view.showConnectionFailed();
        }
    }

    @Override
    public void connect() {
        mGoogleApiClient.connect();
    }

    @Override
    public void disconnect() {
        mGoogleApiClient.disconnect();
    }
}
