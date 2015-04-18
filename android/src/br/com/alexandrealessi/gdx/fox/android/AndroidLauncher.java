package br.com.alexandrealessi.gdx.fox.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;
import br.com.alexandrealessi.gdx.fox.MainGame;
import br.com.alexandrealessi.gdx.fox.android.services.google.GoogleApiConnector;
import br.com.alexandrealessi.gdx.fox.android.services.google.GoogleApiLeaderboards;
import br.com.alexandrealessi.gdx.fox.android.services.google.services.common.ApiConnector;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.PlusOneButton;

public class AndroidLauncher extends AndroidApplication implements AndroidLauncherView {
    private static final String URL = "https://developers.google.com/+";
    private ApiConnector googlePlayConnector;
    private PlusOneButton plusOneButton;

//    private RelativeLayout baseViewLayout;

            /*
        Important: Because it is hard to anticipate the state of each device, you must always check for a
		compatible Google Play services APK before you access Google Play services features.
		 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MainGame mainGame = new MainGame(new GoogleApiLeaderboards());
        AndroidApplicationConfiguration config = getAndroidApplicationConfig();
        RelativeLayout baseViewLayout = getBaseLayout(config, mainGame);
        googlePlayConnector = new GoogleApiConnector(this);
        plusOneButton = addPlusOneButton(baseViewLayout);
        setContentView(baseViewLayout);
    }

    private AndroidApplicationConfiguration getAndroidApplicationConfig() {
        return new AndroidApplicationConfiguration();
    }

    private RelativeLayout getBaseLayout(AndroidApplicationConfiguration config, MainGame mainGame) {
        RelativeLayout layout = new RelativeLayout(this);
        final View view = initializeForView(mainGame, config);
        layout.addView(view);
        return layout;
    }

    private PlusOneButton addPlusOneButton(RelativeLayout baseViewLayout) {
        PlusOneButton plusOneButton = new PlusOneButton(this);
        plusOneButton.setAnnotation(PlusOneButton.ANNOTATION_BUBBLE);
        plusOneButton.setSize(PlusOneButton.SIZE_TALL);
        plusOneButton.setVisibility(View.VISIBLE);

        RelativeLayout.LayoutParams plusOneButtonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        plusOneButtonParams.addRule(RelativeLayout.ALIGN_TOP);
        plusOneButtonParams.addRule(RelativeLayout.ALIGN_RIGHT);
        baseViewLayout.addView(plusOneButton, plusOneButtonParams);
        return plusOneButton;

    }

    private void setupWindow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
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
        if (requestCode == 9001) {
            Toast.makeText(getApplicationContext(), "resolveu", Toast.LENGTH_SHORT).show();
        }else if (requestCode == 9004){
            Toast.makeText(getApplicationContext(), "plusOneButtonInitialize", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        final GoogleApiClient googleApiClient = ((GoogleApiConnector) googlePlayConnector).getGoogleApiClient();
        plusOneButton.initialize(URL, 9004);
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
