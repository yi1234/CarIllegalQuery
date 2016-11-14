package carillegalquery.carillegalquery.childfragment.childhomefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.WebViewActivity;
import carillegalquery.carillegalquery.adapter.homeadapter.MyHomePeccancyListAdapter;
import carillegalquery.carillegalquery.bean.HomePeccancyList;
import carillegalquery.carillegalquery.utils.HttpUrl;
import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeccancyFragment extends Fragment implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {


    private ListView lv_show;
    private MyHomePeccancyListAdapter myHomePeccancyListAdapter;
    private List<HomePeccancyList.DataBean.TopicListBean> list;
    private AsyncHttpClient asyncHttpClient;
    private RadioGroup rg;

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
        rg = (RadioGroup) getView().findViewById(R.id.home_peccancy_rg);
        rg.setOnCheckedChangeListener(this);
        lv_show = (ListView) getView().findViewById(R.id.lv_home_peccancy);
        //TODO适配器
        myHomePeccancyListAdapter = new MyHomePeccancyListAdapter(getActivity(), list);
        lv_show.setAdapter(myHomePeccancyListAdapter);
        lv_show.setOnItemClickListener(this);
        doGet();
    }


    private void doGet() {
        asyncHttpClient.post(getActivity(), HttpUrl.home_peccancy_list_url, null, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                List<HomePeccancyList.DataBean.TopicListBean> topicList = new Gson().fromJson(responseString, HomePeccancyList.class).getData().getTopicList();
                list.addAll(topicList);
                Log.e("TAG", "onItemClick: " + list.get(1).getTopicId());

                myHomePeccancyListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("id", list.get(position).getTopicId());
//        Log.e("TAG", "onItemClick: " + list.get(position - 2).getTopicId());
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            if (group.getChildAt(i).getId() == checkedId) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("id", list.get(i).getClubId());
                startActivity(intent);
                break;
            }
        }
    }
}
