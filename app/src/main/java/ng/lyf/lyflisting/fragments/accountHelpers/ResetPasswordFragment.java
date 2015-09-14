package ng.lyf.lyflisting.fragments.accountHelpers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.activities.AccountHelperActivityWithFragment;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class ResetPasswordFragment extends Fragment {

    private EditText                            passwordResetEditText;
    private EditText                            passwordEditText;
    private Button                              showPasswordButton;
    private Button                              saveButton;
    private Button                              resendResetCodeButton;
    private ProgressBar                         progressBar;
    private AccountHelperActivityWithFragment   activity;


    public ResetPasswordFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_helper_reset_password, container, false);
        initUI(view);
        initListeners();
        return view;
    }

    private void initUI(View view){
        activity                = (AccountHelperActivityWithFragment)getActivity();

        passwordResetEditText   = (EditText) view.findViewById(R.id.passwordReset);
        passwordEditText        = (EditText) view.findViewById(R.id.password);
        showPasswordButton      = (Button) view.findViewById(R.id.showPassword);
        saveButton              = (Button) view.findViewById(R.id.saveButton);
        resendResetCodeButton   = (Button) view.findViewById(R.id.resendResetCode);

        activity.setTitle(R.string.reset_password_title);
        resendResetCodeButton.setText(Html.fromHtml(getString(R.string.resend_reset_code_button_text)));

        RippleEffect.addRippleToView(showPasswordButton);
        RippleEffect.addRippleToView(saveButton);
        RippleEffect.addRippleToView(resendResetCodeButton);

        Common.setPasswordEditTextFontToSans(passwordEditText);
        Common.hideKeyboard(getActivity(), view);
    }

    public void initListeners(){
        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.togglePasswordInputVisibility(passwordEditText, showPasswordButton);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isEditTextCharLengthSix(passwordResetEditText) & Common.isEditTextCharLengthSix(passwordEditText)) {
                    Common.hideKeyboard(activity, getView());
                    savePassword();
                }
            }
        });

        resendResetCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
    }

    private void savePassword(){
        Toast.makeText(getActivity(), "Successfully reset your password", Toast.LENGTH_LONG).show();
        activity.finish();
    }
}
