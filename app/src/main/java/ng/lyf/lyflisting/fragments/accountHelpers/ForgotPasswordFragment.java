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

import ng.lyf.lyflisting.Constants;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.activities.AccountHelperActivityWithFragment;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class ForgotPasswordFragment extends Fragment {

    private EditText                            phoneEditText;
    private Button                              showResetPasswordButton;
    private Button                              sendButton;
    private AccountHelperActivityWithFragment   activity;
    private ProgressBar                         progressBar;

    public ForgotPasswordFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_helper_forgot_password, container, false);

        initUI(view);
        initListeners();
        return view;
    }

    private void initUI(View view){
        activity                = (AccountHelperActivityWithFragment) getActivity();
        progressBar             = (ProgressBar) view.findViewById(R.id.progressBar);
        phoneEditText           = (EditText) view.findViewById(R.id.phone);
        sendButton              = (Button) view.findViewById(R.id.send);
        showResetPasswordButton = (Button) view.findViewById(R.id.show_reset_password_page);

        activity.setTitle(R.string.forgot_password_page_title);
        showResetPasswordButton.setText(Html.fromHtml(activity.getString(R.string.reset_password_button_text)));

        RippleEffect.addRippleToView(sendButton);
        RippleEffect.addRippleToView(showResetPasswordButton);

        Common.hideKeyboard(activity, view);
    }

    private void initListeners(){
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidPhoneEditText(phoneEditText)) {
                    Common.hideKeyboard(activity, getView());
                    sendButton.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    sendCode();
                }
            }
        });

        showResetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { activity.contentFragmentSwitcher(Constants.RESET_PASSWORD_FRAGMENT); }
        });
    }

    private void sendCode() { activity.contentFragmentSwitcher(Constants.RESET_PASSWORD_FRAGMENT); }
}
