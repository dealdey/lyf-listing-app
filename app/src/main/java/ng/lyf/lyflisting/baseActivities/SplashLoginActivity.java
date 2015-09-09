package ng.lyf.lyflisting.baseActivities;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.others.Common;

public class SplashLoginActivity extends AppCompatActivity{


    private static ScrollView enterForm;
    private EditText signInMobileEditText;
    private EditText signInPasswordEditText;

    private Button signInButton;
    private Button showSignInPasswordButton;
    private Button showSignUpFormButton;
    private Button forgetPasswordButton;
    private View signInProgressBar;
    private View signInForm;
    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        signInProgressBar = findViewById(R.id.signInProgressBar);
        enterForm = (ScrollView) findViewById(R.id.enterForm);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
            layoutTransition.setDuration(100);
            enterForm.setLayoutTransition(layoutTransition);
        }

        //signIn form
        signInForm = findViewById(R.id.signInForm);
        signInMobileEditText = (EditText) findViewById(R.id.mobile);
        signInPasswordEditText = (EditText) findViewById(R.id.password);
        signInButton = (Button) findViewById(R.id.signInButton);
        RippleEffect.addRippleToView(signInButton);

        showSignInPasswordButton = (Button) findViewById(R.id.showSignInPassword);
        RippleEffect.addRippleToView(showSignInPasswordButton);
        showSignInPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.togglePasswordInputVisibility(signInPasswordEditText, showSignInPasswordButton);
            }
        });

        showSignUpFormButton = (Button) findViewById(R.id.showSignUpForm);
        showSignUpFormButton.setText(Html.fromHtml("New here? <font color='#E94B0A'>Sign Up!</font>"));
        RippleEffect.addRippleToView(showSignUpFormButton);
        showSignUpFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading) {
                    signInForm.setVisibility(View.GONE);
                    //signUpForm.setVisibility(View.VISIBLE);
                }
            }
        });

        forgetPasswordButton = (Button) findViewById(R.id.forgetPassword);
        RippleEffect.addRippleToView(forgetPasswordButton);
        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

        //A password inputfield font changes by default to monospace, hence the need to change it.
        signInPasswordEditText.setTypeface(Typeface.create("sans", Typeface.NORMAL));

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidPhoneEditText(signInMobileEditText) & Common.isValid6CharsMinEditText(signInPasswordEditText)) {
                    signInButton.setVisibility(View.GONE);
                    signInProgressBar.setVisibility(View.VISIBLE);
                }
                login(signInMobileEditText.getText().toString(), signInPasswordEditText.getText().toString());
            }
        });

        backgroundInitializer();
    }

    private void forgotPassword() {
    }

    public void backgroundInitializer() {
        GoogleTagManagerHelper.initializeTagManager(this);

        new Thread() {
            public void run() {
                fetchInitDataFromServer();

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
                        public void run() {
                            if (true) {
                                revealSignInForm();
                            } else {
//                                startActivity(new Intent(SplashLogin.this, AccountHelperActivity.class));
                                finish();
                            }
                        }
                    });
                }
            }

        }.start();
    }

    private void fetchInitDataFromServer() {
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

    public void login(final String email, final String password) {

    }

}
