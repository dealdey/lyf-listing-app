package ng.lyf.lyflisting.baseActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;

public class SplashLoginActivity extends AppCompatActivity {

    private static ScrollView enterForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        enterForm = (ScrollView) findViewById(R.id.enterForm);

        backgroundInitializer();
    }

    public void backgroundInitializer() {
        GoogleTagManagerHelper.initializeTagManager(this);

        new Thread() {
            public void run() {

                try {
                    int waited = 0;
                    while (waited < 2000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { revealSignInForm(); }
                    });
                }
            }

        }.start();
    }

    public void revealSignInForm() {
        //Animate and show login form
        enterForm.setAlpha(0f);
        enterForm.setVisibility(View.VISIBLE);

        final ImageView logoArea = (ImageView) findViewById(R.id.logoImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_translate);
        logoArea.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                enterForm.animate().alpha(1f).setDuration(700);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}
