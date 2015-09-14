package ng.lyf.lyflisting.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import ng.lyf.lyflisting.Constants;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;
import ng.lyf.lyflisting.utils.animationHelper.CustomAnimator;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

public class SplashLoginActivity extends AppCompatActivity {

    private ScrollView  enterForm;
    private ImageView   logoArea;

    //SIGN IN COMPONENTS
    private EditText    signInMobileEditText;
    private EditText    signInPasswordEditText;
    private Button      signInButton;
    private Button      showSignInPasswordButton;
    private Button      showSignUpFormButton;
    private Button      forgetPasswordButton;
    private View        signInProgressBar;
    private View        signInForm;

    //SIGN UP COMPONENTS
    private EditText    signUpMobileEditText;
    private EditText    signUpPasswordEditText;
    private EditText    emailEditText;
    private EditText    fullNameEditText;
    private Button      signUpButton;
    private Button      showSignUpPasswordButton;
    private Button      showSignInFormButton;
    private View        signUpProgressBar;
    private View        signUpForm;

    private boolean     isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        initUI();
        initListeners();
        backgroundInitializer();
    }

    private void initUI(){
        //LANDING PAGE UI
        enterForm                   = (ScrollView) findViewById(R.id.enterForm);
        logoArea                    = (ImageView) findViewById(R.id.logoImage);

        //SIGN IN UI
        signInForm                  = findViewById(R.id.signInForm);
        signInMobileEditText        = (EditText) findViewById(R.id.mobile);
        signInPasswordEditText      = (EditText) findViewById(R.id.password);
        signInButton                = (Button) findViewById(R.id.signInButton);
        showSignInPasswordButton    = (Button) findViewById(R.id.showSignInPassword);
        forgetPasswordButton        = (Button) findViewById(R.id.forgetPassword);
        showSignUpFormButton        = (Button) findViewById(R.id.showSignUpForm);
        signInProgressBar           = findViewById(R.id.signInProgressBar);

        //A password inputfield font changes by default to monospace, hence changing it to sans.
        signInPasswordEditText.setTypeface(Typeface.create(getResources().getString(R.string.sans_font_family), Typeface.NORMAL));
        showSignUpFormButton.setText(Html.fromHtml(getResources().getString(R.string.sign_up_button_text)));
        RippleEffect.addRippleToView(signInButton);
        RippleEffect.addRippleToView(showSignInPasswordButton);
        RippleEffect.addRippleToView(showSignUpFormButton);
        RippleEffect.addRippleToView(forgetPasswordButton);

        //SIGN UP UI
        signUpForm                  = findViewById(R.id.signUpForm);
        fullNameEditText            = (EditText) findViewById(R.id.fullName);
        emailEditText               = (EditText) findViewById(R.id.email);
        signUpMobileEditText        = (EditText) findViewById(R.id.signUpMobile);
        signUpPasswordEditText      = (EditText) findViewById(R.id.signUpPassword);
        signUpButton                = (Button) findViewById(R.id.signUpButton);
        showSignUpPasswordButton    = (Button) findViewById(R.id.showSignUpPassword);
        showSignInFormButton        = (Button) findViewById(R.id.showSignInForm);
        signUpProgressBar           = findViewById(R.id.signUpProgressBar);

        //A password inputfield font changes by default to monospace, hence the need to change it.
        signUpPasswordEditText.setTypeface(Typeface.create(getResources().getString(R.string.sans_font_family), Typeface.NORMAL));
        showSignInFormButton.setText(Html.fromHtml(getResources().getString(R.string.sign_in_button_text)));
        RippleEffect.addRippleToView(signUpButton);
        RippleEffect.addRippleToView(showSignUpPasswordButton);
    }

    private void initListeners(){
        //SIGN IN LISTENERS
        showSignInPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Common.togglePasswordInputVisibility(signInPasswordEditText, showSignInPasswordButton); }
        });
        showSignUpFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading) {
                    signInForm.setVisibility(View.GONE);
                    signUpForm.setVisibility(View.VISIBLE);
                }
            }
        });
        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { forgotPassword(); }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidPhoneEditText(signInMobileEditText) & Common.isValid6CharsMinEditText(signInPasswordEditText)) {
                    isLoading = true;
                    signInButton.setVisibility(View.GONE);
                    signInProgressBar.setVisibility(View.VISIBLE);
                    login(Common.getStringFromEditText(signInMobileEditText), Common.getStringFromEditText(signInPasswordEditText));
                }
            }
        });

        //SIGN UP LISTENERS
        showSignUpPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Common.togglePasswordInputVisibility(signUpPasswordEditText, showSignUpPasswordButton); }
        });
        showSignInFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading) {
                    signUpForm.setVisibility(View.GONE);
                    signInForm.setVisibility(View.VISIBLE);
                }
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isEditTextNotEmpty(fullNameEditText) & Common.isValidEmailEditText(emailEditText)
                        & Common.isValidPhoneEditText(signUpMobileEditText)
                        & Common.isValid6CharsMinEditText(signUpPasswordEditText)) {
                    signUpButton.setVisibility(View.GONE);
                    signUpProgressBar.setVisibility(View.VISIBLE);
                    isLoading = true;
                    signUp();
                }
            }
        });
    }

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
                            CustomAnimator.animateLayoutChanges(enterForm);
                            CustomAnimator.slideUpAndRevailView(logoArea, enterForm);
                        }
                    });
                }
            }
        }.start();
    }

    private void login(final String email, final String password) { showVerifyPhonePage(); }

    private void forgotPassword() {
        Intent intent = new Intent(SplashLoginActivity.this, AccountHelperActivityWithFragment.class);
        intent.putExtra(Constants.FRAGMENT_TAG, Constants.FORGOT_PASSWORD);
        startActivity(intent);
        finish();
    }

    private void signUp() { showVerifyPhonePage(); }

    private void showVerifyPhonePage(){
        Intent intent = new Intent(SplashLoginActivity.this, AccountHelperActivityWithFragment.class);
        intent.putExtra(Constants.FRAGMENT_TAG, Constants.VERIFY_PHONE);
        startActivity(intent);
        finish();
    }
}
