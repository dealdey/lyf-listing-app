package ng.lyf.lyflisting.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ng.lyf.lyflisting.MainActivity;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.Common;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class VerifyPhoneFragment extends Fragment {

    private EditText codeEditText;
    private Button verifyButton;
    private Button resendVerifyCodeButton;

    public VerifyPhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_verify_phone, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        getActivity().setTitle("Verify Your Phone Number");

        codeEditText = (EditText) view.findViewById(R.id.code);
        verifyButton = (Button) view.findViewById(R.id.verify);
        RippleEffect.addRippleToView(verifyButton);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidEditText(codeEditText)) {
                }
                verifyPhone();
            }
        });

        resendVerifyCodeButton = (Button) view.findViewById(R.id.resendVerifyCode);
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
        ((MainActivity) getActivity()).showFragment(new UpdateBankDetailsFragment());
    }
}