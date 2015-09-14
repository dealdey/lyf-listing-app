package ng.lyf.lyflisting.fragments.accountHelpers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.activities.AccountHelperActivityWithFragment;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

/**
 * A placeholder ng.lyf.lyflisting.fragment containing a simple view.
 */
public class UpdateBankDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button                              saveButton;
    private Spinner                             bankNameSpinner;
    private EditText                            accountNameEditText;
    private EditText                            accountNumberEditText;
    private Spinner                             accountTypeSpinner;
    private ProgressBar                         progressBar;
    private AccountHelperActivityWithFragment   activity;

    public UpdateBankDetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_helper_update_bank_details, container, false);

        initUI(view);
        initListeners();

        return view;
    }

    public void initUI(View view) {
        activity                = (AccountHelperActivityWithFragment) getActivity();
        progressBar             = (ProgressBar) view.findViewById(R.id.progressBar);
        bankNameSpinner         = (Spinner) view.findViewById(R.id.bankName);
        accountTypeSpinner      = (Spinner) view.findViewById(R.id.accountType);
        accountNameEditText     = (EditText) view.findViewById(R.id.accountName);
        accountNumberEditText   = (EditText) view.findViewById(R.id.accountNumber);
        saveButton              = (Button) view.findViewById(R.id.saveButton);
        activity.setTitle(R.string.update_bank_fragment);

        RippleEffect.addRippleToView(saveButton);
        Common.hideKeyboard(activity, view);
    }

    public void initListeners() {
        bankNameSpinner.setOnItemSelectedListener(this);
        accountTypeSpinner.setOnItemSelectedListener(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.isEditTextNotEmpty(accountNameEditText)
                        & Common.isValidAccountNumberEditText(accountNumberEditText)) { save(); }
            }
        });

    }

    private void save() {
        Common.hideKeyboard(activity, getView());
        saveButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Common.changeSelectedSpinnerItemTextUI((TextView) parent.getChildAt(0));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
