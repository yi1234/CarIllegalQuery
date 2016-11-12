package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.HomeSubsList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/11/10/010.
 */

public class MyHomeSubsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<HomeSubsList.DataBean.ItemListBean> list;

    public MyHomeSubsListAdapter(Context mContext, List<HomeSubsList.DataBean.ItemListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public HomeSubsList.DataBean.ItemListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {

        CircleImageView civ_subs_icon;
        ImageView iv_iv_subs_img;
        TextView tv_subs_name, tv_subs_qianming, tv_subs_content, tv_subs_liulan, tv_subs_time;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeSubsList.DataBean.ItemListBean item = getItem(position);
        View layout;
        ViewHolder holder;
        if (convertView == null) {
            layout = LayoutInflater.from(mContext).inflate(R.layout.home_subs_list_item_1, parent, false);
            holder = new ViewHolder();
            holder.civ_subs_icon = (CircleImageView) layout.findViewById(R.id.civ_subs_icon);
            holder.iv_iv_subs_img = (ImageView) layout.findViewById(R.id.iv_subs_img);
            holder.tv_subs_name = (TextView) layout.findViewById(R.id.tv_subs_name);
            holder.tv_subs_qianming = (TextView) layout.findViewById(R.id.tv_subs_qianming);
            holder.tv_subs_content = (TextView) layout.findViewById(R.id.tv_subs_content);
            holder.tv_subs_liulan = (TextView) layout.findViewById(R.id.tv_subs_liulan);
            holder.tv_subs_time = (TextView) layout.findViewById(R.id.tv_subs_time);
            layout.setTag(holder);
        } else {
            layout = convertView;
            holder = (ViewHolder) layout.getTag();
        }
        Picasso.with(mContext).load(item.getWeMediaProfile().getAvatar()).into(holder.civ_subs_icon);
        Picasso.with(mContext).load(item.getArticles().get(0).getContent().getCoverImage()).into(holder.iv_iv_subs_img);
        holder.tv_subs_name.setText(item.getWeMediaProfile().getName());
        holder.tv_subs_qianming.setText(item.getWeMediaProfile().getSummary());
        holder.tv_subs_content.setText(item.getArticles().get(0).getContent().getTitle());
        holder.tv_subs_liulan.setText("浏览量 " + item.getArticles().get(0).getContent().getHitCount());
        String time = new SimpleDateFormat("MM月dd日", Locale.CHINA).format(item.getArticles().get(0).getContent().getPublishTime());
        holder.tv_subs_time.setText(time);
        return layout;
    }
}
