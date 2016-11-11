package carillegalquery.carillegalquery.adapter.ShenQuAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.ActivityCategory;

/**
 * Created by Administrator on 2016/11/11.
 */

public class MyActivityAdapter extends BaseAdapter {

    private Context mContext;
    private List<ActivityCategory.DataBean.ItemListBean> list;
    @Override
    public int getCount() {
        return list.size();
    }

    public MyActivityAdapter(Context mContext, List<ActivityCategory.DataBean.ItemListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ActivityCategory.DataBean.ItemListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_activity_adapter_item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ActivityCategory.DataBean.ItemListBean item = getItem(position);
        Picasso.with(mContext).load(item.getImageUrl()).into(holder.iv_activity);
        holder.tv_activity_content.setText(item.getTitle());
        if(System.currentTimeMillis() > item.getEndTime()){
            holder.tv_activity_status.setText("已结束");
        }else {
            holder.tv_activity_status.setText("活动进行中");
        }
        String startTime = new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(new Date(item.getStartTime()));
        String endTime = new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(new Date(item.getEndTime()));
        holder.tv_acitvity_time_of_duration.setText("活动时间"+startTime+"-"+endTime);
        return convertView;
    }
    class  ViewHolder{
        ImageView iv_activity;
        TextView tv_activity_content;
        TextView tv_activity_status;
        TextView tv_acitvity_time_of_duration;

        public ViewHolder(View convertView) {
            iv_activity = (ImageView) convertView.findViewById(R.id.iv_activity);
            tv_activity_content = (TextView) convertView.findViewById(R.id.tv_activity_content);
            tv_acitvity_time_of_duration = (TextView) convertView.findViewById(R.id.tv_activity_time_of_duration);
            tv_activity_status = (TextView) convertView.findViewById(R.id.tv_activity_status);
        }
    }
}
