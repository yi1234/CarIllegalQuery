package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import carillegalquery.carillegalquery.R;

/**
 * Created by Administrator on 2016/11/11/011.
 */

public class MyHomeYCListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list;

    public MyHomeYCListAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.home_yongche_list_item_1, parent, false);
        return layout;
    }
}
