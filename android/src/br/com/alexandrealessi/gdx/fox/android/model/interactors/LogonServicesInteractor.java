package br.com.alexandrealessi.gdx.fox.android.model.interactors;

/**
 * Created by alexandre on 19/04/15.
 */
//TODO nao esta bom esse nome
public interface LogonServicesInteractor {

    public void connect();

    public void disconnect();

    public interface OnConnectionResultReceivedListener {
        void onConnectionFailed();

        void onConnectionSuccess();
    }

}
