package ng.lyf.lyflisting.fragments.accountHelpers;

import android.app.Activity;
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
public class VerifyPhoneFragment extends Fragment {

    private EditText                            codeEditText;
    private Button                              verifyButton;
    private Button                              resendVerifyCodeButton;
    private Button                              skipButton;
    private boolean                             isLoading;
    private ProgressBar                         resendProgressBar;
    private ProgressBar                         verifyProgressBar;
    private AccountHelperActivityWithFragment   activity;

    public VerifyPhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_helper_verify_phone, container, false);

        initUI(view);
        initListeners();
        return view;
    }

    protected void initUI(View view) {
        activity                = (AccountHelperActivityWithFragment) getActivity();
        verifyProgressBar       = (ProgressBar) view.findViewById(R.id.verifyProgressBar);
        resendProgressBar       = (ProgressBar) view.findViewById(R.id.resendProgressBar);
        codeEditText            = (EditText) view.findViewById(R.id.code);
        skipButton              = (Button) view.findViewById(R.id.skip);
        verifyButton            = (Button) view.findViewById(R.id.verify);
        resendVerifyCodeButton  = (Button) view.findViewById(R.id.resendVerifyCode);
        resendVerifyCodeButton.setText(Html.fromHtml(getResources().getString(R.string.resend_verify_button_text)));
        activity.setTitle(getResources().getString(R.string.verify_phone_fragment));

        RippleEffect.addRippleToView(skipButton);
        RippleEffect.addRippleToView(verifyButton);
        RippleEffect.addRippleToView(resendVerifyCodeButton);

        Common.hideKeyboard(activity, view);
    }

    protected void initListeners() {
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.contentFragmentSwitcher(Constants.UPDATE_BANK);
            }
        });
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValid6CharsMinEditText(codeEditText)) {
                    if (!isLoading) {
                        isLoading = true;
                        verifyPhone();
                    }
                }
            }
        });
        resendVerifyCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading) {
                    isLoading = true;
                    resendVerifyCodeButton.setVisibility(View.GONE);
                    resendProgressBar.setVisibility(View.VISIBLE);
                    resendCode();
                }
            }
        });
    }

    private void verifyPhone() {
        //Connect to server and verify phone

        ((AccountHelperActivityWithFragment) getActivity()).contentFragmentSwitcher(Constants.UPDATE_BANK);
        isLoading = false;
    }

    private void resendCode() {
        resendVerifyCodeButton.setVisibility(View.VISIBLE);
        resendProgressBar.setVisibility(View.GONE);
        isLoading = false;
    }
}