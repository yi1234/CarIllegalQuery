package carillegalquery.carillegalquery.childfragment.childSheQuFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import carillegalquery.carillegalquery.DetailActivity;
import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.adapter.shenQuAdapter.MyShenZhenAdapter;
import carillegalquery.carillegalquery.bean.ImageListCategory;
import carillegalquery.carillegalquery.bean.ShenZhenCategory;
import cz.msebera.android.httpclient.Header;

import static carillegalquery.carillegalquery.bean.ShenZhenCategory.TYPE_CONTENT_UNIMAGVIEW;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShenZhenShiFragment extends Fragment {
    public static final String CLUBID= "clubId";
    private static final String TAG = "TAG";
    private ListView mListView;
    private AsyncHttpClient asyncHttpClient;
    private MyShenZhenAdapter myShenZhenAdapter;
    private String mUrl = "http://cheyouquan.kakamobi.com/api/open/group/city-topic.htm?_platform=android&_srv=t&_appName=kakasiji&_product=%E6%B1%BD%E8%BD%A6%E8%BF%9D%E7%AB%A0%E6%9F%A5%E8%AF%A2&_vendor=null&_renyuan=LMN&_version=6.5.1&_system=MRA58K&_manufacturer=Xiaomi&_systemVersion=6.0&_device=Redmi%20Note%204&_imei=862963036311088&_productCategory=weizhang&_operator=M&_androidId=5b5555fd3904d3b8&_mac=02%3A00%3A00%3A00%3A00%3A00&_appUser=1fa393128f33433a82fd248911e4150e&_pkgName=cn.mucang.kaka.android&_screenDpi=3.0&_screenWidth=1080&_screenHeight=1920&_network=wifi&_launch=11&_firstTime=2016-11-08%2020%3A32%3A16&_apiLevel=23&_userCity=440300&_p=&_gpsType=baidu&_cityName=%E6%B7%B1%E5%9C%B3%E5%B8%82&_cityCode=440300&_gpsCity=440300&_longitude=113.909932&_latitude=22.578992&_ipCity=440300&_j=1.0&_webviewVersion=4.7&_r=a2054f1625054ea99f77e877b90920bc&_saturnVersion=11.7&cityCode=440300&_saturnPageLocation=%7B%22data%22%3A%7B%22clubId%22%3A0%2C%22tagId%22%3A445%2C%22topicId%22%3A0%7D%2C%22location%22%3A%22tagTopicList%22%7D&sign=05cf6ba29ac0d984c0195a56956233e501";
    private RelativeLayout mLayout;
    private List<ImageListCategory> mImageList;
    public ShenZhenShiFragment() {
        // Required empty public constructor
    }
    private List<ShenZhenCategory.DataBean.ItemListBean> mList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncHttpClient = new AsyncHttpClient();
        myShenZhenAdapter = new MyShenZhenAdapter(getActivity(), mList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shen_zhen_shi_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData(mUrl);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemClick: =========================" );
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Log.e(TAG, "clubId "+ mList.get((int)id).getTopicId());
                intent.putExtra(CLUBID,mList.get((int)id).getTopicId());

                startActivity(intent);
            }
        });
    }

    private void initView() {
        mListView = (ListView) getView().findViewById(R.id.shen_zhen_listView);
        mListView.setAdapter(myShenZhenAdapter);
        mLayout = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.view_shenzhen_head_view, new FrameLayout(getActivity()),false);
        //加载头布局
        mListView.addHeaderView(mLayout);


    }

    private void initData(String strUrl) {
        asyncHttpClient.post(getActivity(), strUrl, null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "加载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject jsonObject = new JSONObject(responseString);
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONArray itemList = data.getJSONArray("itemList");
                    for (int i = 0; i < itemList.length(); i++) {
                        JSONObject jsonObject1 = itemList.getJSONObject(i);

                        if(TYPE_CONTENT_UNIMAGVIEW ==jsonObject1.getInt("type")){
                            JSONArray imageList = jsonObject1.getJSONArray("imageList");
                            for (int j = 0; j < imageList.length(); j++) {
                                JSONObject jsonObject2 = imageList.getJSONObject(i);
                                int height = jsonObject2.getInt("height");
                                int width = jsonObject2.getInt("width");
                                String url = jsonObject2.getString("url");
                                ImageListCategory imageListCategory = new ImageListCategory(height, width, url);
                                mImageList = new ArrayList<>();
                                mImageList.add(imageListCategory);
                                Log.e(TAG, "mImageList = "+ mImageList.size() );
                            }
                        }
                    }
                    myShenZhenAdapter.notifyDataSetChanged();
                } catch (JSONException e) {

                }

                List<ShenZhenCategory.DataBean.ItemListBean> itemList = new Gson().fromJson(responseString, ShenZhenCategory.class).getData().getItemList();

                mList.addAll(itemList);
                myShenZhenAdapter.notifyDataSetChanged();
            }
        });

    }

}
