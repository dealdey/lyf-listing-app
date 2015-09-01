package ng.lyf.lyflisting.utils.others;

import android.content.Context;
import android.widget.Toast;

import ng.lyf.lyflisting.LyfListingApplication;


/**
 * Created by Ugo on 6/15/2015.
 */
public class Messaging {

    public static void show(Object object) {
        Context context = LyfListingApplication.getContext();
        Toast.makeText(context, String.valueOf(object), Toast.LENGTH_SHORT).show();
    }

    public static void showResource(int resource) {
        Context context = LyfListingApplication.getContext();
        Toast.makeText(context, resource, Toast.LENGTH_SHORT).show();
    }
}
