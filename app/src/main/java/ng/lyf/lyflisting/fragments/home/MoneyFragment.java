package ng.lyf.lyflisting.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.activities.HomeActivityWithFragment;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;

/**
 * Created by Ayoola.
 */
public class MoneyFragment extends ListFragment {

    private View                        viewGroupAddButton;
    private View                        rootView;
    private View                        emptyView;
    private ListView                    listView;
    private HomeActivityWithFragment    activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_money, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initListeners();
    }

    public void initUI() {
        activity            = (HomeActivityWithFragment) getActivity();
        listView            = getListView();
        emptyView           = rootView.findViewById(R.id.empty_view);
        viewGroupAddButton  = rootView.findViewById(R.id.view_group_add_button);

        activity.setTitle(R.string.my_money_page_title);

        RippleEffect.addRippleToView(viewGroupAddButton);

        listView.setEmptyView(emptyView);
    }

    public void initListeners() {
        viewGroupAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBusiness();
            }
        });
    }

    private void addBusiness() {}
}
