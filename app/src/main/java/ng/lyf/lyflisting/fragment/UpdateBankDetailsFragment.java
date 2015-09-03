package ng.lyf.lyflisting.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.baseActivities.MainActivity;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.others.Common;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class UpdateBankDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private EditText passwordResetEditText;
    private EditText passwordEditText;
    private Button showPasswordButton;
    private Button saveButton;
    private Button resendResetCodeButton;
    private Spinner bankNameSpinner;
    private EditText accountNameEditText;
    private EditText accountNumberEditText;
    private Spinner accountTypeSpinner;
    private ArrayAdapter accountTypeArrayAdapter;
    private ArrayAdapter bankArrayAdapter;

    public UpdateBankDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_bank_details, container, false);

        getActivity().setTitle("Update Bank Account Details");

        bankNameSpinner = (Spinner) view.findViewById(R.id.bankName);
        bankNameSpinner.setOnItemSelectedListener(this);
        accountTypeSpinner = (Spinner) view.findViewById(R.id.accountType);
        accountTypeSpinner.setOnItemSelectedListener(this);

        accountNameEditText = (EditText) view.findViewById(R.id.accountName);
        accountNumberEditText = (EditText) view.findViewById(R.id.accountNumber);

        saveButton = (Button) view.findViewById(R.id.saveButton);
        RippleEffect.addRippleToView(saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isValidEditText(accountNameEditText)
                        & Common.isValidAccountNumberEditText(accountNumberEditText)) {
                }
                save();
            }
        });

        Common.hideKeyboard(getActivity(), view);

        return view;
    }

    private void save() {
        ((MainActivity) getActivity()).showFragment(new ForgotPasswordFragment());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) parent.getChildAt(0);
        textView.setTextColor(Color.GRAY);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setPadding(5, 0, 0, 0);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
