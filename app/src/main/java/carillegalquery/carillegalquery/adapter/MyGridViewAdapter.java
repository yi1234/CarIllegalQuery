package carillegalquery.carillegalquery.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.bean.ShenZhenCategory;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/11/10.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<ShenZhenCategory.DataBean.ItemListBean.ImageListBean> mList;

    public MyGridViewAdapter(Context context, List<ShenZhenCategory.DataBean.ItemListBean.ImageListBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public ShenZhenCategory.DataBean.ItemListBean.ImageListBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.view_shenzhen_gridview, parent, false);

        int measuredHeight = parent.getMeasuredHeight();
        Log.d(TAG, "getView: measuredHeight="+measuredHeight);
        if(mList.size()> 3){
            GridView.LayoutParams lp = (GridView.LayoutParams) mImageView.getLayoutParams();
            lp.height = (int) (measuredHeight/2-mContext.getResources().getDisplayMetrics().density*4+0.5f);
            lp.width=lp.height;
            mImageView.setLayoutParams(lp);
        }else {
            GridView.LayoutParams lp = (GridView.LayoutParams)mImageView.getLayoutParams();
            lp.height = (int)(measuredHeight-mContext.getResources().getDisplayMetrics().density*4+0.5f);
            lp.width=lp.height;
            mImageView.setLayoutParams(lp);
        }


        Picasso.with(mContext).load(getItem(position).getDetail().getUrl()).into(mImageView);
        return mImageView;
    }

}
