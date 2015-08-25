package ng.lyf.lyflisting.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.utils.Common;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class ResetPasswordFragment extends Fragment {

    private EditText passwordResetEditText;
    private EditText passwordEditText;
    private Button showPasswordButton;
    private Button saveButton;
    private Button resendResetCodeButton;

    public ResetPasswordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        getActivity().setTitle("Reset Password");

        passwordResetEditText = (EditText) view.findViewById(R.id.passwordReset);
        passwordEditText = (EditText) view.findViewById(R.id.password);
        //A password inputfield font changes by default to monospace, hence the need to change it.
        passwordEditText.setTypeface(Typeface.create("sans", Typeface.NORMAL));

        showPasswordButton = (Button) view.findViewById(R.id.showPassword);
        RippleEffect.addRippleToView(showPasswordButton);
        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.togglePasswordInputVisibility(passwordEditText, showPasswordButton);
            }
        });

        saveButton = (Button) view.findViewById(R.id.saveButton);
        RippleEffect.addRippleToView(saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidEditText(passwordResetEditText) & Common.isValidPasswordEditText(passwordEditText)) {
                    //save();
                }
            }
        });

        resendResetCodeButton = (Button) view.findViewById(R.id.resendResetCode);
        resendResetCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resendCode();
            }
        });

        Common.hideKeyboard(getActivity(), view);

        return view;
    }
}
