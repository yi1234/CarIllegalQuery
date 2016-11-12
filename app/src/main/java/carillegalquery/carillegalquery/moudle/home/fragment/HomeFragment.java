package carillegalquery.carillegalquery.moudle.home.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.moudle.home.homeadapter.MyVpMainAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private TabLayout tab_layout;
    private ViewPager vp_main;
    private MyVpMainAdapter myVpMainAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tab_layout = (TabLayout) getView().findViewById(R.id.tab_layout);
        vp_main = (ViewPager) getView().findViewById(R.id.vp_main);
        myVpMainAdapter = new MyVpMainAdapter(getChildFragmentManager());
        vp_main.setAdapter(myVpMainAdapter);
        tab_layout.setupWithViewPager(vp_main);
    }
}
