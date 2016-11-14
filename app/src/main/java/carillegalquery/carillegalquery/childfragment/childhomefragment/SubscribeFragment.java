package carillegalquery.carillegalquery.childfragment.childhomefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import carillegalquery.carillegalquery.adapter.homeadapter.MyHomeSubsListAdapter;
import carillegalquery.carillegalquery.bean.HomeSubsList;
import carillegalquery.carillegalquery.utils.HttpUrl;
import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscribeFragment extends Fragment {


    private ListView lv_show;
    private MyHomeSubsListAdapter myHomeSubsListAdapter;
    private AsyncHttpClient asyncHttpClient;
    private List<HomeSubsList.DataBean.ItemListBean> list;

    public SubscribeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscribe, container, false);
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
        lv_show = (ListView) getView().findViewById(R.id.lv_subs_view);
        //TODO 适配器

        myHomeSubsListAdapter = new MyHomeSubsListAdapter(getActivity(), list);
        lv_show.setAdapter(myHomeSubsListAdapter);
        doPost();

    }

    private void doPost() {
        asyncHttpClient.post(getActivity(), HttpUrl.home_subs_list_url, null, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                List<HomeSubsList.DataBean.ItemListBean> itemList = new Gson().fromJson(responseString, HomeSubsList.class).getData().getItemList();
                list.addAll(itemList);
                myHomeSubsListAdapter.notifyDataSetChanged();
            }
        });
    }
}
