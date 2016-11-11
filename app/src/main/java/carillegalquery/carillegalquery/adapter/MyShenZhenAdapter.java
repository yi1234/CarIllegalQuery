package carillegalquery.carillegalquery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.ImageListCategory;
import carillegalquery.carillegalquery.bean.ShenZhenCategory;
import de.hdodenhof.circleimageview.CircleImageView;

import static carillegalquery.carillegalquery.bean.ShenZhenCategory.TYPE_CONTENT_IMAGEVIEW;
import static carillegalquery.carillegalquery.bean.ShenZhenCategory.TYPE_CONTENT_UNIMAGVIEW;

/**
 * Created by Administrator on 2016/11/10.
 */

public class MyShenZhenAdapter extends BaseAdapter {
    private Context mContext;
    private List<ImageListCategory> mGridViewList;
    private List<ShenZhenCategory.DataBean.ItemListBean> list;
    public static final int TYPE = 1048576;

    public MyShenZhenAdapter(Context mContext, List<ShenZhenCategory.DataBean.ItemListBean> list) {
        this.mContext = mContext;
        this.mGridViewList = mGridViewList;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        //注意返回的类型数字
        // 必须数字要小于类型总数getViewTypeCount();
        if (TYPE == getItem(position).getType()) {
            return TYPE_CONTENT_IMAGEVIEW;
        }
        return TYPE_CONTENT_UNIMAGVIEW;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ShenZhenCategory.DataBean.ItemListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShenZhenCategory.DataBean.ItemListBean item = getItem(position);
        //判断是哪种布局
        if (getItemViewType(position) == TYPE_CONTENT_UNIMAGVIEW) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.view_shenzhen_adapter_unimageview_item2, parent, false);
                //重用同一个ViewHolder 通过类型去判断绑定那些控件
                convertView.setTag(new ViewHolder(convertView, TYPE_CONTENT_UNIMAGVIEW));
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            //更新相同界面的UI
            updateUI(holder, item);
            //更新不同的UI
            holder.rb_message.setText(String.valueOf(item.getCommentCount()));
            holder.rb_zan.setText(String.valueOf(item.getZanCount()));
        } else {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.view_shenzhen_adapter_imageview_item1, parent, false);
                //重用同一个ViewHolder 通过类型去判断绑定那些控件
                convertView.setTag(new ViewHolder(convertView, TYPE_CONTENT_IMAGEVIEW));
            }
            final ViewHolder holder = (ViewHolder) convertView.getTag();
            //更新相同界面的UI
            updateUI(holder, item);
            //更新不同的UI
            if (item.getCommentCount() > 0) {
                holder.tv_count.setText(String.valueOf(item.getCommentCount()));

            } else {
                holder.tv_count.setText("0" + "人回答");
            }


            final List<ShenZhenCategory.DataBean.ItemListBean.ImageListBean> imageList = getItem(position).getImageList();

            if (imageList != null) {
                holder.mGridView.setVisibility(View.VISIBLE);
                //通过屏幕宽度设置图片高度
                int width = mContext.getResources().getDisplayMetrics().widthPixels - (int) (mContext.getResources().getDisplayMetrics().density * 20 + 0.5f);//得到GridView 测量后的宽度
                int size = imageList.size();
                int spacing = (int) (mContext.getResources().getDisplayMetrics().density * 4 + 0.5f);
                int height;
                //确定高度
                if (size > 3) {
                    height = (int) (width / 3.0 * 2 + spacing);
                } else {
                    height = width / 3;
                }
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.mGridView.getLayoutParams();
                lp.height = height;
                holder.mGridView.setLayoutParams(lp);
                holder.mGridView.setAdapter(new MyGridViewAdapter(mContext, imageList));
            } else {
                holder.mGridView.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    private void updateUI(ViewHolder holder, ShenZhenCategory.DataBean.ItemListBean item) {

        Picasso.with(mContext).load(item.getAuthor().getAvatar()).into(holder.civ_icon);
        holder.tv_nickName.setText(item.getAuthor().getName());
        String mData = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(item.getCreateTime()));
        holder.tv_replytime.setText(mData);
        holder.tv_location.setText("来自 " + item.getLocation());
        if (item.getTitle() != null) {
            holder.tv_title.setText(item.getTitle());
        } else {
            holder.tv_title.setVisibility(View.GONE);
        }
        holder.tv_content.setText(item.getSummary());
        holder.tv_type.setText(item.getTagList().get(0).getLabelName());
        holder.tv_type_location.setText(item.getTagList().get(0).getLabelName());
    }

    class ViewHolder {
        CircleImageView civ_icon;
        GridView mGridView;
        TextView tv_nickName;
        TextView tv_replytime;
        TextView tv_location;
        TextView tv_content;
        TextView tv_title;
        TextView tv_type;
        TextView tv_type_location;
        TextView tv_count;
        RadioButton rb_message;
        RadioButton rb_zan;


        public ViewHolder(View convertView, int type) {
            civ_icon = (CircleImageView) convertView.findViewById(R.id.civ_icon);
            tv_nickName = (TextView) convertView.findViewById(R.id.tv_nickName);
            tv_replytime = (TextView) convertView.findViewById(R.id.tv_time);
            tv_location = (TextView) convertView.findViewById(R.id.tv_location);
            tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            tv_type = (TextView) convertView.findViewById(R.id.tv_type);
            tv_type_location = (TextView) convertView.findViewById(R.id.tv_type_location);
            if (type == TYPE_CONTENT_IMAGEVIEW) {
                tv_count = (TextView) convertView.findViewById(R.id.tv_count);
                mGridView = (GridView) convertView.findViewById(R.id.gridView);
            } else if (type == TYPE_CONTENT_UNIMAGVIEW) {
                rb_message = (RadioButton) convertView.findViewById(R.id.rb_message);
                rb_zan = (RadioButton) convertView.findViewById(R.id.rb_zan);

            }
        }
    }
}
