package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.HomePeccancyList;

/**
 * Created by Administrator on 2016/11/10/010.
 */

public class MyHomePeccancyListAdapter extends BaseAdapter {

    private Context mContext;
    private List<HomePeccancyList.DataBean.TopicListBean> list;

    public MyHomePeccancyListAdapter(Context mContext, List<HomePeccancyList.DataBean.TopicListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public static final int HOME_peccancy_LIST_TYPE_1 = 0;
    public static final int HOME_peccancy_LIST_TYPE_2 = 1;

    @Override
    public int getItemViewType(int position) {
        int size = list.get(position).getImageList().size();
        if (size > 1) {
            return HOME_peccancy_LIST_TYPE_1;
        } else if (size == 1)
            return HOME_peccancy_LIST_TYPE_2;
        return -1;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public HomePeccancyList.DataBean.TopicListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder1 {

        TextView tv_home_peccancy_title, tv_home_peccancy_content, tv_home_peccancy_title2, tv_home_peccancy_content2, tv_zan, tv_home_peccancy_msg;
        ImageView iv_home_peccancy_img_1, iv_home_peccancy_img_2, iv_home_peccancy_img_3, iv_home_peccancy_img_4;
    }

    class ViewHolder2 {

        TextView tv_home_peccancy_title2, tv_home_peccancy_content2, tv_zan, tv_home_peccancy_msg, tv_clubName;
        ImageView iv_home_peccancy_img_4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == HOME_peccancy_LIST_TYPE_1) {
            ViewHolder1 holder;
            View layout;
            if (convertView == null) {
                layout = LayoutInflater.from(mContext).inflate(R.layout.home_peccancy_list_item_1, parent, false);
                holder = new ViewHolder1();
                holder.tv_home_peccancy_title = (TextView) layout.findViewById(R.id.tv_home_peccancy_title);
                holder.tv_home_peccancy_content = (TextView) layout.findViewById(R.id.tv_home_peccancy_content);
                holder.iv_home_peccancy_img_1 = (ImageView) layout.findViewById(R.id.iv_home_peccancy_img_1);
                holder.iv_home_peccancy_img_2 = (ImageView) layout.findViewById(R.id.iv_home_peccancy_img_2);
                holder.iv_home_peccancy_img_3 = (ImageView) layout.findViewById(R.id.iv_home_peccancy_img_3);
                layout.setTag(holder);

            } else {
                layout = convertView;
                holder = (ViewHolder1) layout.getTag();
            }
            HomePeccancyList.DataBean.TopicListBean item = getItem(position);
            holder.tv_home_peccancy_title.setText(item.getTitle());
            holder.tv_home_peccancy_content.setText(item.getSummary());
            Picasso.with(mContext).load(item.getImageList().get(0).getList().getUrl()).into(holder.iv_home_peccancy_img_1);
            Picasso.with(mContext).load(item.getImageList().get(1).getList().getUrl()).into(holder.iv_home_peccancy_img_2);
            if(item.getImageList().size() > 2){
                Picasso.with(mContext).load(item.getImageList().get(2).getList().getUrl()).into(holder.iv_home_peccancy_img_3);
            }else {
                holder.iv_home_peccancy_img_3.setVisibility(View.GONE);
            }
            Log.d("TAG", "getItemViewType: " + list.get(position).getType());
            return layout;
        } else if (getItemViewType(position) == HOME_peccancy_LIST_TYPE_2) {
            ViewHolder2 holder;
            View layout;
            if (convertView == null) {
                layout = LayoutInflater.from(mContext).inflate(R.layout.home_peccancy_list_item_2, parent, false);
                holder = new ViewHolder2();
                holder.iv_home_peccancy_img_4 = (ImageView) layout.findViewById(R.id.iv_home_peccancy_img_4);
                holder.tv_home_peccancy_msg = (TextView) layout.findViewById(R.id.tv_home_peccancy_msg);
                holder.tv_home_peccancy_title2 = (TextView) layout.findViewById(R.id.tv_home_peccancy_title2);
                holder.tv_home_peccancy_content2 = (TextView) layout.findViewById(R.id.tv_home_peccancy_content2);
                holder.tv_clubName = (TextView) layout.findViewById(R.id.tv_clubName);
                holder.tv_zan = (TextView) layout.findViewById(R.id.tv_zan);
                layout.setTag(holder);
            } else {
                layout = convertView;
                holder = (ViewHolder2) layout.getTag();
            }
            HomePeccancyList.DataBean.TopicListBean item = getItem(position);
            Picasso.with(mContext).load(item.getImageList().get(0).getList().getUrl()).into(holder.iv_home_peccancy_img_4);
            holder.tv_home_peccancy_title2.setText(item.getTitle());
            holder.tv_home_peccancy_content2.setText(item.getSummary());
            holder.tv_clubName.setText(item.getClubName());
            holder.tv_zan.setText(item.getZanCountStr());
            holder.tv_home_peccancy_msg.setText(item.getCommentCountStr());
            Log.w("TAG", "getItemViewType: " + list.get(position).getType());

            return layout;
        }
        return null;
    }
}
