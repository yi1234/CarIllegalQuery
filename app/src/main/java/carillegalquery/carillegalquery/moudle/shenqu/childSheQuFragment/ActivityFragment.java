package carillegalquery.carillegalquery.moudle.shenqu.childSheQuFragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import carillegalquery.carillegalquery.DetailActivity;
import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.moudle.shenqu.shenQuAdapter.MyActivityAdapter;
import carillegalquery.carillegalquery.moudle.shenqu.shenQuAdapter.MyViewPagerAdapter;
import carillegalquery.carillegalquery.moudle.shenqu.bean.ActivityCategory;
import carillegalquery.carillegalquery.moudle.shenqu.bean.ActivityViewPagerCategory;
import carillegalquery.carillegalquery.moudle.shenqu.bean.MyOnPageChangListener;
import carillegalquery.carillegalquery.utils.LooperViewUtils;
import cz.msebera.android.httpclient.Header;

import static carillegalquery.carillegalquery.utils.LooperViewUtils.LOOPVIEW;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment {

    private static final String activityUrl = "http://cheyouquan.kakamobi.com/api/open/activity/list-other.htm?_platform=android&_srv=t&_appName=kakasiji&_product=%E6%B1%BD%E8%BD%A6%E8%BF%9D%E7%AB%A0%E6%9F%A5%E8%AF%A2&_vendor=null&_renyuan=LMN&_version=6.5.1&_system=MRA58K&_manufacturer=Xiaomi&_systemVersion=6.0&_device=Redmi%20Note%204&_imei=862963036311088&_productCategory=weizhang&_operator=M&_androidId=5b5555fd3904d3b8&_mac=02%3A00%3A00%3A00%3A00%3A00&_appUser=1fa393128f33433a82fd248911e4150e&_pkgName=cn.mucang.kaka.android&_screenDpi=3.0&_screenWidth=1080&_screenHeight=1920&_network=wifi&_launch=12&_firstTime=2016-11-08%2020%3A32%3A16&_apiLevel=23&_userCity=440300&_p=&_gpsType=baidu&_cityName=%E6%B7%B1%E5%9C%B3%E5%B8%82&_cityCode=440300&_gpsCity=440300&_longitude=113.909903&_latitude=22.579005&_ipCity=440300&_j=1.0&_webviewVersion=4.7&_r=04e86e92eb0a46c8b3599a77073db92e&_saturnVersion=11.7&product=wzcx&sign=b67be477b202784b99173a292bdd4d4d01";
    private static final String activityViewPagerUrl = "http://cheyouquan.kakamobi.com/api/open/activity/list.htm?_platform=android&_srv=t&_appName=kakasiji&_product=%E6%B1%BD%E8%BD%A6%E8%BF%9D%E7%AB%A0%E6%9F%A5%E8%AF%A2&_vendor=null&_renyuan=LMN&_version=6.5.1&_system=MRA58K&_manufacturer=Xiaomi&_systemVersion=6.0&_device=Redmi%20Note%204&_imei=862963036311088&_productCategory=weizhang&_operator=M&_androidId=5b5555fd3904d3b8&_mac=02%3A00%3A00%3A00%3A00%3A00&_appUser=1fa393128f33433a82fd248911e4150e&_pkgName=cn.mucang.kaka.android&_screenDpi=3.0&_screenWidth=1080&_screenHeight=1920&_network=wifi&_launch=53&_firstTime=2016-11-08%2020%3A32%3A16&_apiLevel=23&_userCity=440300&_p=&_gpsType=baidu&_cityName=%E6%B7%B1%E5%9C%B3%E5%B8%82&_cityCode=440300&_gpsCity=440300&_longitude=113.909919&_latitude=22.578985&_ipCity=440300&_j=1.0&_webviewVersion=4.7&_r=fbebf792ff7a4c64b9780a8706b5bafa&_saturnVersion=11.7&product=wzcx&sign=a636c68abf4eaafaaf59a92a5dc3088a01";

    private ListView mListView;
    private ViewPager mViewPager;
    private MyActivityAdapter myActivityAdapter;
    private List<ActivityCategory.DataBean.ItemListBean> mList = new ArrayList<>();
    private List<ActivityViewPagerCategory.DataBean.FocusBean> mViewPagerList = new ArrayList<>();
    private AsyncHttpClient asyncHttpClient;
    private String[] url = {activityUrl, activityViewPagerUrl};
    private MyViewPagerAdapter myViewPagerAdapter;
    private View mLayout;
    private RadioGroup rg_listener;


    public ActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myActivityAdapter = new MyActivityAdapter(getActivity(), mList);
        myViewPagerAdapter = new MyViewPagerAdapter(mViewPagerList, getActivity());
        asyncHttpClient = new AsyncHttpClient();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acitivity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(url);
        initView();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("url",mList.get(position).getActivityUrl());
                startActivity(intent);
            }
        });
    }

    private void initData(String[] url) {
        for (int i = 0; i < url.length; i++) {
            final int mType = i;
            asyncHttpClient.post(getActivity(), url[i], null, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Toast.makeText(getActivity(), "加载失败", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if (mType == 0) {
                        List<ActivityCategory.DataBean.ItemListBean> itemList = new Gson().fromJson(responseString, ActivityCategory.class).getData().getItemList();
                        mList.addAll(itemList);
                        myActivityAdapter.notifyDataSetChanged();

                    } else {
                        List<ActivityViewPagerCategory.DataBean.FocusBean> focus = new Gson().fromJson(responseString, ActivityViewPagerCategory.class).getData().getFocus();
                        mViewPagerList.addAll(focus);
                        myViewPagerAdapter.notifyDataSetChanged();
                        LooperViewUtils.startLooperView(handler);
                    }

                }
            });
        }


    }



    private void initView() {
        mListView = (ListView) getView().findViewById(R.id.activity_listView);
        mListView.setAdapter(myActivityAdapter);
        mLayout = LayoutInflater.from(getActivity()).inflate(R.layout.view_activity_head, new LinearLayout(getActivity()), false);
        mListView.addHeaderView(mLayout);
        mViewPager = (ViewPager) mLayout.findViewById(R.id.activity_viewPager);
        mViewPager.setAdapter(myViewPagerAdapter);
        rg_listener = (RadioGroup) mLayout.findViewById(R.id.activity_viewPager_rg_listener);
        mViewPager.addOnPageChangeListener(new MyOnPageChangListener(){
            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton) rg_listener.getChildAt(position);
                radioButton.setChecked(true);
            }
        });



    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case LOOPVIEW:
                    mViewPager.setCurrentItem((mViewPager.getCurrentItem() + 1) % mViewPagerList.size());
                    break;
            }
            return false;
        }
    });

}
