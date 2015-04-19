package br.com.alexandrealessi.gdx.fox.android.presenter;

import android.content.Context;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncherView;
import br.com.alexandrealessi.gdx.fox.android.model.interactors.GoogleApiClientInteractor;
import br.com.alexandrealessi.gdx.fox.android.model.interactors.GoogleApiClientInteractorImpl;

/**
 * Created by alexandre on 19/04/15.
 */
public class LoginAtGooglePresenterImpl implements LoginAtGooglePresenter, GoogleApiClientInteractor.OnConnectionResultReceivedListener {

    private Context context;
    private GoogleApiClientInteractor googleApiClientInteractor;
    private AndroidLauncherView view;

    public LoginAtGooglePresenterImpl(Context context, AndroidLauncherView view) {
        this.context = context;
        googleApiClientInteractor = new GoogleApiClientInteractorImpl(context, this);
        this.view = view;
    }

    @Override
    public void connect() {
        googleApiClientInteractor.connect();
    }

    @Override
    public void disconnect() {
        googleApiClientInteractor.disconnect();
    }

    @Override
    public void onConnectionFailed() {
        view.showConnectionFailed();
    }

    @Override
    public void onConnectionSuccess() {
        view.showConnected();
    }
}
