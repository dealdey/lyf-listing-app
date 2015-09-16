package ng.lyf.lyflisting.fragments.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.activities.HomeActivityWithFragment;
import ng.lyf.lyflisting.adapters.NavigationDrawerAdapter;
import ng.lyf.lyflisting.models.NavDrawerItem;

public class FragmentDrawer extends Fragment {
    private int                         previousPosition;
    private View                        drawerContainerView;
    private Toolbar                     mToolbar;
    private ListView                    drawerListView;
    private DrawerLayout                mDrawerLayout;
    private static int[]                icons;
    private static String[]             titles = null;
    private ActionBarDrawerToggle       mDrawerToggle;
    private NavigationDrawerAdapter     drawerAdapter;
    private HomeActivityWithFragment    activity;

    public FragmentDrawer() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initUI(getView());
        initListeners();
    }

    public void initUI(View view) {
        activity = (HomeActivityWithFragment) getActivity();

        // drawer labels
        titles  = activity.getResources().getStringArray(R.array.nav_drawer_labels);
        icons   = new int[]{R.drawable.businesses, R.drawable.add, R.drawable.profile,
                R.drawable.money, R.drawable.settings, R.drawable.help, R.drawable.logout};

        mToolbar            = (Toolbar) activity.findViewById(R.id.toolbar);
        mDrawerLayout       = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        drawerContainerView = activity.findViewById(R.id.fragment_navigation_drawer);
        drawerListView      = (ListView) drawerContainerView.findViewById(R.id.drawer_list);
        drawerAdapter       = new NavigationDrawerAdapter(activity, getData());
        drawerListView.setAdapter(drawerAdapter);

        //Test user profile
        ((TextView) view.findViewById(R.id.name)).setText("Henry Okafor");
        ((TextView) view.findViewById(R.id.email)).setText("henry@dealdey.com");
    }

    private void initListeners() {
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (previousPosition != position) { activity.contentFragmentSwitcher(position); }
                mDrawerLayout.closeDrawer(drawerContainerView);
                previousPosition = position;
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(activity, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                activity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                activity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mToolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public ActionBarDrawerToggle getDrawerToggle(){ return mDrawerToggle; }

    public static List<NavDrawerItem> getData() {

        List<NavDrawerItem> data = new ArrayList<>();

        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setIconResource(icons[i]);

            if (i == 0) { navItem.setCount(titles.length); }

            data.add(navItem);
        }
        return data;
    }
}