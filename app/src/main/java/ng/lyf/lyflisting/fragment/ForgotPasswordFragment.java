package ng.lyf.lyflisting.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ng.lyf.lyflisting.baseActivities.MainActivity;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.others.Common;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class ForgotPasswordFragment extends Fragment {

    private EditText phoneEditText;
    private EditText passwordEditText;
    private Button showPasswordButton;
    private Button showResetPasswordButton;
    private Button sendButton;

    public ForgotPasswordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        getActivity().setTitle("Forgot Password?");

        phoneEditText = (EditText) view.findViewById(R.id.phone);

        sendButton = (Button) view.findViewById(R.id.send);
        RippleEffect.addRippleToView(sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidEditText(phoneEditText)) {
                    sendCode();
                }
            }
        });

        showResetPasswordButton = (Button) view.findViewById(R.id.showResetPassword);
        RippleEffect.addRippleToView(showResetPasswordButton);
        showResetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showFragment(new ResetPasswordFragment());
            }
        });

                Common.hideKeyboard(getActivity(), view);

        return view;
    }

    private void sendCode() {
        ((MainActivity) getActivity()).showFragment(new ResetPasswordFragment());
    }
}
