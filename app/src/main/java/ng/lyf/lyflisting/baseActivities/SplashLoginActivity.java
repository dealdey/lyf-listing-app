package ng.lyf.lyflisting.baseActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ScrollView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;
import ng.lyf.lyflisting.utils.animationHelper.CustomAnimator;

public class SplashLoginActivity extends AppCompatActivity {

    private ScrollView enterForm;
    private ImageView logoArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        //Splashscreen components
        enterForm = (ScrollView) findViewById(R.id.enterForm);
        logoArea = (ImageView) findViewById(R.id.logoImage);

        backgroundInitializer();
    }

    public void backgroundInitializer() {
        GoogleTagManagerHelper.initializeTagManager(this);

        //Simulate network loading
        new Thread() {
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 2000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {}
                finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            CustomAnimator.slideUpAndRevailView(logoArea, enterForm);
                        }
                    });
                }
            }
        }.start();
    }

    public void revealSignInForm() {
    }
}
