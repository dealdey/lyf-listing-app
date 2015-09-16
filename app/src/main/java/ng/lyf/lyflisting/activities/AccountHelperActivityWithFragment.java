package ng.lyf.lyflisting.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ng.lyf.lyflisting.Constants;
import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.fragments.accountHelpers.ForgotPasswordFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.ResetPasswordFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.UpdateBankDetailsFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.VerifyPhoneFragment;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

public class AccountHelperActivityWithFragment extends BaseAppCompatActivityWithFragment {

    private Toolbar     toolbar;
    private int         contentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initUI() {
        setContentView(R.layout.activity_account_helper);
        toolbar     = (Toolbar) findViewById(R.id.toolbar);
        contentID   = R.id.content;
        setSupportActionBar(toolbar);
    }

    public void contentFragmentSwitcher(int targetFragmentInt) {
        switch (targetFragmentInt) {
            case Constants.VERIFY_PHONE_FRAGMENT:
                Common.replaceContentFragment(this, contentID, new VerifyPhoneFragment());
                break;
            case Constants.UPDATE_BANK_FRAGMENT:
                Common.replaceContentFragment(this, contentID, new UpdateBankDetailsFragment());
                break;
            case Constants.FORGOT_PASSWORD_FRAGMENT:
                Common.replaceContentFragment(this, contentID, new ForgotPasswordFragment());
                break;
            case Constants.RESET_PASSWORD_FRAGMENT:
                Common.replaceContentFragment(this, contentID, new ResetPasswordFragment());
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
