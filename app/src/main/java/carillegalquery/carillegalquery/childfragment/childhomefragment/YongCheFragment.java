package carillegalquery.carillegalquery.childfragment.childhomefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.adapter.homeadapter.MyHomeYCHeadVpAdapter;
import carillegalquery.carillegalquery.adapter.homeadapter.MyHomeYCListAdapter;
import carillegalquery.carillegalquery.bean.HomeYCHeadVPImg;
import carillegalquery.carillegalquery.utils.HttpUrl;
import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class YongCheFragment extends Fragment {



    private ListView lv_show;
    private View headView;
    private ViewPager vp_show;
    private MyHomeYCHeadVpAdapter myHomeYCHeadVpAdapter;
    private List<HomeYCHeadVPImg.DataBean.ItemListBean> list;
    private List<String> arrayList;
    private MyHomeYCListAdapter myHomeYCListAdapter;
    private AsyncHttpClient asyncHttpClient;

    public YongCheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yong_che, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        arrayList = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv_show = (ListView) getView().findViewById(R.id.lv_yongche_show);
        //TODO 适配器
        headView = LayoutInflater.from(getContext()).inflate(R.layout.home_yongche_list_head_item_1, null);
        asyncHttpClient = new AsyncHttpClient();
        lv_show.addHeaderView(headView);
        initHeadView();
        myHomeYCListAdapter = new MyHomeYCListAdapter(getContext(), arrayList);
        lv_show.setAdapter(myHomeYCListAdapter);
    }

    private void initHeadView() {
        vp_show = (ViewPager) headView.findViewById(R.id.vp_yongche_show);
        myHomeYCHeadVpAdapter = new MyHomeYCHeadVpAdapter(getContext(), list);
        vp_show.setAdapter(myHomeYCHeadVpAdapter);
        vpDoPost();
    }

    private void vpDoPost() {
        asyncHttpClient.post(getContext(), HttpUrl.home_yongche_headvp_img_url,null, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                List<HomeYCHeadVPImg.DataBean.ItemListBean> itemList = new Gson().fromJson(responseString, HomeYCHeadVPImg.class).getData().getItemList();
                Log.i("TAG", "onSuccess: itemList"+itemList.size());
                list.addAll(itemList);
//                ImageView image = (ImageView) headView.findViewById(R.id.iv_home_yongche_vphead_img);
//                Picasso.with(getActivity()).load(itemList.get())
                myHomeYCHeadVpAdapter.notifyDataSetChanged();
            }
        });
    }
}
