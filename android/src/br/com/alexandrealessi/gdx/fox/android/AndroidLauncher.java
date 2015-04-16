package br.com.alexandrealessi.gdx.fox.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import br.com.alexandrealessi.gdx.fox.MainGame;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.example.games.basegameutils.BaseGameActivity;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MainGame(), config);

		/*
		Important: Because it is hard to anticipate the state of each device, you must always check for a
		compatible Google Play services APK before you access Google Play services features.
		 */
    }
}
