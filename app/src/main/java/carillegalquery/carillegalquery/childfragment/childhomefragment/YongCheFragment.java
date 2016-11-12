package carillegalquery.carillegalquery.childfragment.childhomefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import carillegalquery.carillegalquery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YongCheFragment extends Fragment {




    private ListView lv_show;
    private View headView;
    private ViewPager vp_show;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv_show = (ListView) getView().findViewById(R.id.lv_yongche_show);
        //TODO 适配器
        headView = LayoutInflater.from(getContext()).inflate(R.layout.home_yongche_list_head_item_1, null);
        initHeadView();
        lv_show.addHeaderView(headView);
    }

    private void initHeadView() {
        vp_show = (ViewPager) headView.findViewById(R.id.vp_yongche_show);

    }
}
