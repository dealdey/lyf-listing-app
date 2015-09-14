package ng.lyf.lyflisting.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ng.lyf.lyflisting.Constants;

/**
 * Created by Ayoola Ajebeku on 9/14/2015.
 */
public abstract class BaseAppCompatActivityWithFragment extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initListeners();
        contentFragmentSwitcher();
    }

    public abstract void initUI();

    public void contentFragmentSwitcher() {
        int targetFragmentInt = getIntent().getIntExtra(Constants.FRAGMENT_TAG, 0);
        if (targetFragmentInt > 0) { contentFragmentSwitcher(targetFragmentInt); }
    }

    public abstract void contentFragmentSwitcher(int targetFragmentInt);

    public void initListeners() { getSupportFragmentManager().addOnBackStackChangedListener(this); }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void onBackStackChanged() {
        boolean backEnabled = getSupportFragmentManager().getBackStackEntryCount() > 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(backEnabled);
        getSupportActionBar().setDisplayShowHomeEnabled(backEnabled);
    }

    public void setTitle(int stringID){ setTitle(getString(stringID)); }
}
