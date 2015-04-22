package br.com.alexandrealessi.gdx.fox.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import br.com.alexandrealessi.gdx.fox.base.BaseGame;
import br.com.alexandrealessi.gdx.fox.base.RequestHandler;
import br.com.alexandrealessi.gdx.fox.android.presenter.GooglePlayServicesPresenter;
import br.com.alexandrealessi.gdx.fox.android.presenter.GooglePlayServicesPresenterImpl;
import br.com.alexandrealessi.gdx.fox.comet.CometGame;
import br.com.alexandrealessi.gdx.fox.soccer.SoccerGame;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.plus.PlusOneButton;

public class AndroidLauncher extends AndroidApplication implements AndroidLauncherView, PlusOneButton.OnPlusOneClickListener, RequestHandler {

    private PlusOneButton plusOneButton;
    private GooglePlayServicesPresenter googlePlayServicesPresenter;
    private Button btnCallSoccerGame;
    private Button btnCallCometGame;
    private SoccerGame soccerGame;
    private CometGame cometGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soccerGame = new SoccerGame(this);
        cometGame = new CometGame(this);
        loadGame(soccerGame);
        googlePlayServicesPresenter = new GooglePlayServicesPresenterImpl(this, this);

        btnCallSoccerGame = (Button) findViewById(R.id.btnCallSoccerGame);
        btnCallSoccerGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGame(soccerGame);
            }
        });

        btnCallCometGame = (Button) findViewById(R.id.btnCallCometGame);
        btnCallCometGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGame(cometGame);
            }
        });

    }

    private void loadGame (BaseGame game){
        final AndroidApplicationConfiguration config = getAndroidApplicationConfig();
        RelativeLayout baseLayout = setContentViewWithGameView(config, game);
        inflatePlusOneButton(baseLayout);

    }

    private RelativeLayout setContentViewWithGameView(AndroidApplicationConfiguration config, BaseGame baseGame) {
        RelativeLayout baseLayout = inflateBaseView(config, baseGame);
        setContentView(baseLayout);
        return baseLayout;
    }

    private AndroidApplicationConfiguration getAndroidApplicationConfig() {
        return new AndroidApplicationConfiguration();
    }

    RelativeLayout layout;
    private RelativeLayout inflateBaseView(AndroidApplicationConfiguration config, BaseGame baseGame) {
        layout = new RelativeLayout(this);
        final View view = initializeForView(baseGame, config);
        layout.addView(view);
        return layout;
    }

    private void inflatePlusOneButton(RelativeLayout baseViewLayout) {
        View plusOneLayout = LayoutInflater.from(getApplicationContext()).inflate(R.layout.android_launcher_layout, null);
        baseViewLayout.addView(plusOneLayout, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        if (plusOneButton == null){
            plusOneButton = (PlusOneButton) plusOneLayout.findViewById(R.id.plus_one_button);
        }
    }

    private void setupWindow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        googlePlayServicesPresenter.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googlePlayServicesPresenter.disconnect();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9001) {
            Toast.makeText(getApplicationContext(), "resolveu", Toast.LENGTH_SHORT).show();
        } else if (requestCode == 9004) {
            Toast.makeText(getApplicationContext(), "plusOneButtonInitialize", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        final String shareUrl = getString(R.string.app_share_url);
        plusOneButton.initialize(shareUrl, this);
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

    // OnPlusOneClickListener

    @Override
    public void onPlusOneClick(Intent intent) {
        startActivityForResult(intent, 0);
    }

    // RequestHandler

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void submitScore(String mappedKey, long score) {
        googlePlayServicesPresenter.submitScore(mappedKey, score);
    }

    @Override
    public void incrementAchievment(String mappedKey, int amount) {
        googlePlayServicesPresenter.incrementAchievment(mappedKey, amount);
    }

    @Override
    public void unlockAchievment(String mappedKey) {
        googlePlayServicesPresenter.unlockAchievment(mappedKey);
    }

    @Override
    public void setPlusOneButtonVisible(boolean visible) {
        plusOneButton.setVisibility((visible) ? View.VISIBLE : View.GONE);
    }
}
