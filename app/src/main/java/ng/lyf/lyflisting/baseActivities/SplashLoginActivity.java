package ng.lyf.lyflisting.baseActivities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;
import ng.lyf.lyflisting.utils.animationHelper.CustomAnimator;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

public class SplashLoginActivity extends AppCompatActivity {

    private ScrollView  enterForm;
    private ImageView   logoArea;

    //SignIn components
    private EditText    signInMobileEditText;
    private EditText    signInPasswordEditText;
    private Button      signInButton;
    private Button      showSignInPasswordButton;
    private Button      showSignUpFormButton;
    private Button      forgetPasswordButton;
    private View        signInProgressBar;
    private View        signInForm;

    private boolean     isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        //Splash Screen UI
        enterForm   = (ScrollView) findViewById(R.id.enterForm);
        logoArea    = (ImageView) findViewById(R.id.logoImage);

        initSignInUI();

        backgroundInitializer();
    }

    private void initSignInUI(){
        signInForm                  = findViewById(R.id.signInForm);
        signInMobileEditText        = (EditText) findViewById(R.id.mobile);
        signInPasswordEditText      = (EditText) findViewById(R.id.password);
        signInButton                = (Button) findViewById(R.id.signInButton);
        showSignInPasswordButton    = (Button) findViewById(R.id.showSignInPassword);
        forgetPasswordButton        = (Button) findViewById(R.id.forgetPassword);
        showSignUpFormButton        = (Button) findViewById(R.id.showSignUpForm);
        signInProgressBar           = findViewById(R.id.signInProgressBar);

        //A password inputfield font changes by default to monospace, hence changing it to sans.
        signInPasswordEditText.setTypeface(Typeface.create("sans", Typeface.NORMAL));

        showSignUpFormButton.setText(Html.fromHtml("New here? <font color='#E94B0A'>Sign Up!</font>"));

        RippleEffect.addRippleToView(signInButton);
        RippleEffect.addRippleToView(showSignInPasswordButton);
        RippleEffect.addRippleToView(showSignUpFormButton);
        RippleEffect.addRippleToView(forgetPasswordButton);

        initSignInListeners();
    }

    private void initSignInListeners(){
        showSignInPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.togglePasswordInputVisibility(signInPasswordEditText, showSignInPasswordButton);
            }
        });

        showSignUpFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading) {
                    signInForm.setVisibility(View.GONE);
                    //signUpForm.setVisibility(View.VISIBLE);
                }
            }
        });

        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidPhoneEditText(signInMobileEditText) &
                        Common.isValid6CharsMinEditText(signInPasswordEditText)) {
                    isLoading = true;
                    signInButton.setVisibility(View.GONE);
                    signInProgressBar.setVisibility(View.VISIBLE);
                }

                login( Common.getStringFromEditText(signInMobileEditText),
                        Common.getStringFromEditText(signInPasswordEditText));
            }
        });
    }

    private void login(final String email, final String password) {}

    private void forgotPassword() {}

    private void backgroundInitializer() {
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
}
