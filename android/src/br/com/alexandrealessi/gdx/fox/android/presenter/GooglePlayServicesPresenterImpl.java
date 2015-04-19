package br.com.alexandrealessi.gdx.fox.android.presenter;

import android.content.Context;
import br.com.alexandrealessi.gdx.fox.android.AndroidLauncherView;
import br.com.alexandrealessi.gdx.fox.android.model.interactors.GooglePlayServicesInteractor;
import br.com.alexandrealessi.gdx.fox.android.model.interactors.GooglePlayServicesInteractorImpl;
import br.com.alexandrealessi.gdx.fox.android.model.interactors.LogonServicesInteractor;

/**
 * Created by alexandre on 19/04/15.
 */
public class GooglePlayServicesPresenterImpl implements GooglePlayServicesPresenter, LogonServicesInteractor.OnConnectionResultReceivedListener {

    private GooglePlayServicesInteractor googlePlayServicesInteractor;
    private Context context;

    private AndroidLauncherView view;

    public GooglePlayServicesPresenterImpl(Context context, AndroidLauncherView view) {
        this.context = context;
        googlePlayServicesInteractor = new GooglePlayServicesInteractorImpl(context, this);
        this.view = view;
    }

    @Override
    public void connect() {
        googlePlayServicesInteractor.connect();
    }

    @Override
    public void disconnect() {
        googlePlayServicesInteractor.disconnect();
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
