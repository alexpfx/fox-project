package br.com.alexandrealessi.gdx.fox.android.model.interactors;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.plus.Plus;

/**
 * Created by alexandre on 19/04/15.
 */
public class GoogleApiClientInteractorImpl implements GoogleApiClientInteractor, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient googleApiClient;
    private Context context;
    private OnConnectionResultReceivedListener onConnectionResultReceivedListener;
    private boolean mResolvingError = false;
    private final String tag = GoogleApiClientInteractor.class.getName();

    public GoogleApiClientInteractorImpl(Context context, OnConnectionResultReceivedListener onConnectionResultReceivedListener) {
        this.context = context;
        this.onConnectionResultReceivedListener = onConnectionResultReceivedListener;
        googleApiClient = new GoogleApiClient.Builder(context)
                .addApi(Games.API)
                .addApi(Plus.API)
                .addScope(Games.SCOPE_GAMES)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
    }

    @Override
    public void connect() {
        googleApiClient.connect();
    }

    @Override
    public void disconnect() {
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(tag, "connected");
        onConnectionResultReceivedListener.onConnectionSuccess();
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.d(tag, "connection suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (mResolvingError) {
            return;
        }
        if (!result.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), (Activity) context, 0).show();
            onConnectionResultReceivedListener.onConnectionFailed();
            mResolvingError = true;
            return;
        }
        try {
            mResolvingError = true;
            result.startResolutionForResult((Activity) context, 0);
        } catch (IntentSender.SendIntentException e) {
            Log.e(tag, "Exception while starting resolution activity");
        }

    }
}
