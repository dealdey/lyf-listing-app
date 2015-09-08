package ng.lyf.lyflisting.baseActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.fragments.accountHelpers.ForgotPasswordFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.ResetPasswordFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.UpdateBankDetailsFragment;
import ng.lyf.lyflisting.fragments.accountHelpers.VerifyPhoneFragment;

public class AccountHelperActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private Toolbar toolbar;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_helper);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setCollapsible(true);
        toolbar.setTitle("Lyf Listing");

        String method = getIntent().getStringExtra("fragmentName");
        if (method != null) {
            if (method.equals("verifyPhone")) {
                showFragment(new VerifyPhoneFragment());
            } else if (method.equals("forgotPassword")) {
                showFragment(new ForgotPasswordFragment());
            } else if (method.equals("resetPassword")) {
                showFragment(new ResetPasswordFragment());
            } else if (method.equals("updateBankDetails")) {
                showFragment(new UpdateBankDetailsFragment());
            }
        }

        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).addToBackStack(null).commitAllowingStateLoss();
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

    @Override
    public void onBackPressed() {
        System.err.println(getSupportFragmentManager().getBackStackEntryCount());
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
//            super.onBackPressed();
            finish();
        }
    }

    @Override
    public void onBackStackChanged() {
        boolean backEnabled = getSupportFragmentManager().getBackStackEntryCount() > 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(backEnabled);
        getSupportActionBar().setDisplayShowHomeEnabled(backEnabled);
    }
}
