package carillegalquery.carillegalquery.moudle.home.childhomefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import carillegalquery.carillegalquery.moudle.home.homeadapter.MyHomePeccancyListAdapter;
import carillegalquery.carillegalquery.moudle.home.bean.HomePeccancyList;
import carillegalquery.carillegalquery.utils.HttpUrl;
import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeccancyFragment extends Fragment {


    private ListView lv_show;
    private MyHomePeccancyListAdapter myHomePeccancyListAdapter;
    private List<HomePeccancyList.DataBean.TopicListBean> list;
    private AsyncHttpClient asyncHttpClient;

    public PeccancyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_peccancy, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncHttpClient = new AsyncHttpClient();
        list = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //listView嵌套在scrollView里面的高度默认为unSepeication(未指定)
        //两种方法
        //1.动态设置listView的高度
        //2.继承listView ,制定高度(Integer.MAX_VALUE>>2)和模式来创建一个规格(一般用这种)

        lv_show = (ListView) getView().findViewById(R.id.lv_home_peccancy);
        //TODO适配器
        myHomePeccancyListAdapter = new MyHomePeccancyListAdapter(getActivity(), list);
        lv_show.setAdapter(myHomePeccancyListAdapter);

        doGet();
    }


    private void doGet() {
        asyncHttpClient.post(getActivity(), HttpUrl.home_peccancy_list_url,null, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                List<HomePeccancyList.DataBean.TopicListBean> topicList = new Gson().fromJson(responseString, HomePeccancyList.class).getData().getTopicList();
                Log.i("TAG", "topicList=" + topicList.size());
                list.addAll(topicList);
                Log.w("TAG", "onSuccess: "+topicList.get(0).getType() );
                myHomePeccancyListAdapter.notifyDataSetChanged();
            }
        });
    }
}
