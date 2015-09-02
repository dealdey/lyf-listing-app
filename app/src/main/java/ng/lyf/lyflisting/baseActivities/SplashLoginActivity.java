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
import android.widget.Spinner;
import android.widget.TextView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.analytics.GoogleTagManagerHelper;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.others.Common;

public class SplashLoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static ScrollView enterForm;
    private EditText signInMobileEditText;
    private EditText signInPasswordEditText;
    private EditText signUpMobileEditText;
    private EditText signUpPasswordEditText;
    private EditText emailEditText;
    private EditText fullNameEditText;

    private Spinner bankNameSpinner;
    private EditText accountNameEditText;
    private EditText accountNumberEditText;
    private Spinner accountTypeSpinner;

    private Button signInButton;
    private Button signUpButton;
    private Button showSignInPasswordButton;
    private Button showSignUpPasswordButton;
    private Button showSignUpFormButton;
    private Button showSignInFormButton;
    private Button forgetPasswordButton;
    private View signInProgressBar;
    private View signUpProgressBar;
    private View signUpForm;
    private View signInForm;
    private boolean isLoading;
    private ArrayAdapter bankArrayAdapter;
    private ArrayAdapter accountTypeArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        signInProgressBar = findViewById(R.id.signInProgressBar);
        signUpProgressBar = findViewById(R.id.signUpProgressBar);
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
                    signUpForm.setVisibility(View.VISIBLE);
                    enterForm.computeScroll();
                }
            }
        });

        forgetPasswordButton = (Button) findViewById(R.id.forgetPassword);
        RippleEffect.addRippleToView(forgetPasswordButton);
        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //A password inputfield font changes by default to monospace, hence the need to change it.
        signInPasswordEditText.setTypeface(Typeface.create("sans", Typeface.NORMAL));

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidPhoneEditText(signInMobileEditText) & Common.isValidPasswordEditText(signInPasswordEditText)) {
                    signInButton.setVisibility(View.GONE);
                    signInProgressBar.setVisibility(View.VISIBLE);
                    login(signInMobileEditText.getText().toString(), signInPasswordEditText.getText().toString());
                }
            }
        });

        //signUp form
        signUpForm = findViewById(R.id.signUpForm);
        fullNameEditText = (EditText) findViewById(R.id.fullName);
        emailEditText = (EditText) findViewById(R.id.email);
        accountNameEditText = (EditText) findViewById(R.id.accountName);
        accountNumberEditText = (EditText) findViewById(R.id.accountNumber);

        bankNameSpinner = (Spinner) findViewById(R.id.bankName);
        bankNameSpinner.setOnItemSelectedListener(this);
        accountTypeSpinner = (Spinner) findViewById(R.id.accountType);
        accountTypeSpinner.setOnItemSelectedListener(this);

        signUpMobileEditText = (EditText) findViewById(R.id.signUpMobile);
        signUpPasswordEditText = (EditText) findViewById(R.id.signUpPassword);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        RippleEffect.addRippleToView(signUpButton);
        showSignUpPasswordButton = (Button) findViewById(R.id.showSignUpPassword);
        //A password inputfield font changes by default to monospace, hence the need to change it.
        signUpPasswordEditText.setTypeface(Typeface.create("sans", Typeface.NORMAL));

        showSignUpPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.togglePasswordInputVisibility(signUpPasswordEditText, showSignUpPasswordButton);
            }
        });

        showSignInFormButton = (Button) findViewById(R.id.showSignInForm);
        showSignInFormButton.setText(Html.fromHtml("Already a member? <font color='#E94B0A'>Sign In!</font>"));
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
                /*if (Common.isValidEditText(fullNameEditText) & Common.isValidEmailEditText(emailEditText)
                        & Common.isValidPhoneEditText(signUpMobileEditText)
                        & Common.isValidPasswordEditText(signUpPasswordEditText)
                        & Common.isValidEditText(bankNameSpinner) & Common.isValidEditText(accountNameEditText)
                        & Common.isValidEditText(accountNumberEditText) & Common.isValidEditText(accountTypeSpinner)) {
                    signUpButton.setVisibility(View.GONE);
                    signUpProgressBar.setVisibility(View.VISIBLE);
                    signUp();
                }*/
                signUp();
            }
        });

        backgroundInitializer();
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
//                                startActivity(new Intent(SplashLogin.this, MainActivity.class));
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

    private void signUp() {
        Intent intent = new Intent(SplashLoginActivity.this, MainActivity.class);
        intent.putExtra("fragmentName", "verifyPhone");
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
