package ng.lyf.lyflisting.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.baseActivities.AccountHelperActivity;
import ng.lyf.lyflisting.utils.animationHelper.RippleEffect;

/**
 * Created by Ayoola.
 */
public class MoneyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_money, container, false);
        View addButton = rootView.findViewById(R.id.addButton);
        RippleEffect.addRippleToView(addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBusiness();
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void addBusiness() {
//        if (user.isValidated()) {
//            showAddBusiness();
//        } else {
//
//        }
        Intent intent = new Intent(getActivity(), AccountHelperActivity.class);
        intent.putExtra("fragmentName", "verifyPhone");
        startActivity(intent);

    }
}
