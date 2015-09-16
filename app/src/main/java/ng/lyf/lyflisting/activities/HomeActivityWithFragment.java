package ng.lyf.lyflisting.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.adapters.NavigationDrawerAdapter;
import ng.lyf.lyflisting.fragments.home.BusinessesFragment;
import ng.lyf.lyflisting.fragments.home.FragmentDrawer;
import ng.lyf.lyflisting.fragments.home.MoneyFragment;
import ng.lyf.lyflisting.utils.genericHelpers.Common;

public class HomeActivityWithFragment extends BaseAppCompatActivityWithFragment {

    private int                     contentID;
    private boolean                 highlightPosition;
    private Toolbar                 mToolbar;
    private ListView                drawerListView;
    private SearchView              searchView;
    private ActionBarDrawerToggle   drawerToggle;
    private NavigationDrawerAdapter drawerAdapter;

    @Override
    public void initUI() {
        setContentView(R.layout.activity_main);

        mToolbar        = (Toolbar) findViewById(R.id.toolbar);
        contentID       = R.id.container_body;
        drawerToggle    = ((FragmentDrawer) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer)).getDrawerToggle();
        drawerListView  = (ListView) findViewById(R.id.drawer_list);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        contentFragmentSwitcher(0);
    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchView                  = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        } else if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (drawerToggle != null) { drawerToggle.onConfigurationChanged(newConfig); }
    }

    public void contentFragmentSwitcher(int targetFragmentInt) {
        highlightPosition = false;
        drawerAdapter = (NavigationDrawerAdapter) (drawerListView).getAdapter();

        switch (targetFragmentInt) {
            case 0:
                Common.replaceContentFragment(this, contentID, new BusinessesFragment());
                highlightPosition = true;
                break;
            case 3:
                Common.replaceContentFragment(this, contentID, new MoneyFragment());
                highlightPosition = true;
                break;
            default:
                break;
        }

        if (drawerAdapter != null && highlightPosition) {
            drawerAdapter.setSelectedPosition(targetFragmentInt);
            drawerAdapter.notifyDataSetChanged();
        }
    }
}
