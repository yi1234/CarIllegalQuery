package carillegalquery.carillegalquery.adapter.shenQuAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.ActivityViewPagerCategory;

/**
 * Created by Administrator on 2016/11/11.
 */

public class MyViewPagerAdapter extends PagerAdapter {
    private List<ActivityViewPagerCategory.DataBean.FocusBean> list;
    private Context mContext;

    public MyViewPagerAdapter(List<ActivityViewPagerCategory.DataBean.FocusBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.view_activity_view_pager_item, container, false);
        Picasso.with(mContext).load(list.get(position).getImageUrl()).into(mImageView);
        container.addView(mImageView);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
