package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import carillegalquery.carillegalquery.R;

/**
 * Created by Administrator on 2016/11/11/011.
 */

public class MyHomeYCHeadVpAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> list;

    public MyHomeYCHeadVpAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.home_yongche_vp_litem_1, container, false);
        //Picasso.with(mContext).load(null).into(mImageView);

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
