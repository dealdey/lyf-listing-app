package ng.lyf.lyflisting.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ng.lyf.lyflisting.R;
import ng.lyf.lyflisting.models.NavDrawerItem;

/**
 * Created by Ayoola on 9/4/2015.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    private int                     selectedPosition;
    private Context                 context;
    private List<NavDrawerItem>     data = Collections.emptyList();

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.data       = data;
        this.context    = context;
    }

    @Override
    public int getCount() { return data.size(); }

    @Override
    public Object getItem(int position) { return data.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    public void setSelectedPosition(int position) { this.selectedPosition = position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view                    = inflater.inflate(R.layout.nav_drawer_row, parent, false);
            viewHolder              = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder              = (ViewHolder) view.getTag();
        }

        NavDrawerItem current       = data.get(position);
        viewHolder.title.setText(current.getTitle());
        viewHolder.businessCount.setText(current.getCount() == 0 ? "" : "" + current.getCount());
        viewHolder.icon.setImageResource(current.getIconResource());

        if (position == selectedPosition) {
            viewHolder.itemView.setBackgroundResource(R.color.light_grey);
        } else {
            viewHolder.itemView.setBackgroundResource(R.color.transparent);
        }
        return view;
    }

    class ViewHolder {
        public TextView title;
        public TextView businessCount;
        public ImageView icon;
        public View itemView;

        public ViewHolder(View itemView) {
            icon            = (ImageView) itemView.findViewById(R.id.icon);
            title           = (TextView) itemView.findViewById(R.id.title);
            businessCount   = (TextView) itemView.findViewById(R.id.businessCount);
            this.itemView   = itemView;
        }
    }
}