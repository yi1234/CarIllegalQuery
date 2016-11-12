package carillegalquery.carillegalquery.adapter.homeadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import carillegalquery.carillegalquery.childfragment.childhomefragment.PeccancyFragment;
import carillegalquery.carillegalquery.childfragment.childhomefragment.SubscribeFragment;

/**
 * Created by Administrator on 2016/11/10/010.
 */

public class MyVpMainAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {new PeccancyFragment(), new SubscribeFragment(), new PeccancyFragment()};
    private String[] tabName = {"违章", "订阅", "用车"};

    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }

    public MyVpMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
