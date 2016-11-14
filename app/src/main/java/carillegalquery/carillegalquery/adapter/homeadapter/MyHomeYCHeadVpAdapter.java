package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.HomeYCHeadVPImg;

/**
 * Created by Administrator on 2016/11/11/011.
 */

public class MyHomeYCHeadVpAdapter extends PagerAdapter {

    private Context mContext;
    private List<HomeYCHeadVPImg.DataBean.ItemListBean> list;

    public MyHomeYCHeadVpAdapter(Context mContext, List<HomeYCHeadVPImg.DataBean.ItemListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.home_yongche_vp_litem_1, container, false);
        ImageView mImageView = (ImageView) layout.findViewById(R.id.iv_home_yongche_vphead_img);
        Picasso.with(mContext).load(list.get(position).getImageUrl()).into(mImageView);
        TextView title = (TextView) layout.findViewById(R.id.tv_yongche_head_title);
        title.setText(list.get(position).getTitle());

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
