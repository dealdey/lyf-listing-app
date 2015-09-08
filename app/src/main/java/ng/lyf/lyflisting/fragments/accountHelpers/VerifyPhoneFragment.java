package ng.lyf.lyflisting.fragments.accountHelpers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.baseActivities.AccountHelperActivity;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.others.Common;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class VerifyPhoneFragment extends Fragment {

    private EditText codeEditText;
    private Button verifyButton;
    private Button resendVerifyCodeButton;
    private Button skipButton;

    public VerifyPhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_helper_verify_phone, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        getActivity().setTitle("Verify Your Phone Number");

        codeEditText = (EditText) view.findViewById(R.id.code);

        skipButton = (Button) view.findViewById(R.id.skip);
        RippleEffect.addRippleToView(skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AccountHelperActivity) getActivity()).showFragment(new UpdateBankDetailsFragment());
            }
        });

        verifyButton = (Button) view.findViewById(R.id.verify);
        RippleEffect.addRippleToView(verifyButton);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValid6CharsMinEditText(codeEditText)) {
                }
                verifyPhone();
            }
        });

        resendVerifyCodeButton = (Button) view.findViewById(R.id.resendVerifyCode);
        resendVerifyCodeButton.setText(Html.fromHtml("<font color='#E94B0A'>Click here</font> to resend verification code"));
        RippleEffect.addRippleToView(resendVerifyCodeButton);
        resendVerifyCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resendCode();
            }
        });

        Common.hideKeyboard(getActivity(), view);
    }

    private void verifyPhone() {
        ((AccountHelperActivity) getActivity()).showFragment(new UpdateBankDetailsFragment());
    }
}