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
public class GooglePlayServicesInteractorImpl implements GooglePlayServicesInteractor, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final GoogleApiClient googleApiClient;
    private Context context;
    private OnConnectionResultReceivedListener onConnectionResultReceivedListener;
    private boolean mResolvingError = false;
    private final String tag = LogonServicesInteractor.class.getName();

    public GooglePlayServicesInteractorImpl(Context context, OnConnectionResultReceivedListener onConnectionResultReceivedListener) {
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
        mResolvingError = false;
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
            mResolvingError = false;
            return;
        }
        try {
            mResolvingError = true;
            result.startResolutionForResult((Activity) context, 0);
        } catch (IntentSender.SendIntentException e) {
            mResolvingError = false;
            Log.e(tag, "Exception while starting resolution activity");
        }
    }

    @Override
    public void submitScore(String key, long score) {
        if (isConnected()) {
            Games.Leaderboards.submitScore(googleApiClient, key, score);
        }

    }

    @Override
    public void incrementAchievment(String achievmentId, int amount) {
        if (isConnected()) {
            Games.Achievements.increment(googleApiClient, achievmentId, amount);
        }

    }

    @Override
    public void unlockAchievment(String achievmentId) {
        if (isConnected()) {
            Games.Achievements.unlock(googleApiClient, achievmentId);
        }

    }

    private boolean isConnected() {
        return googleApiClient != null && googleApiClient.isConnected();
    }

}
