package carillegalquery.carillegalquery.moudle.shenqu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.moudle.shenqu.shenQuAdapter.MySheQuAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheQuFragment extends Fragment {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MySheQuAdapter mSheQuAdapter;

    public SheQuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSheQuAdapter = new MySheQuAdapter(getChildFragmentManager());
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_she_qu_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTabLayout = (TabLayout) getView().findViewById(R.id.tablayout);
        mViewPager = (ViewPager) getView().findViewById(R.id.vp_show);

        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setAdapter(mSheQuAdapter);
    }
}
