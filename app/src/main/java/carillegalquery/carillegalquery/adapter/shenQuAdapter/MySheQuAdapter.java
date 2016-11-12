package carillegalquery.carillegalquery.adapter.shenQuAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import carillegalquery.carillegalquery.childfragment.childSheQuFragment.ActivityFragment;
import carillegalquery.carillegalquery.childfragment.childSheQuFragment.HotFragment;
import carillegalquery.carillegalquery.childfragment.childSheQuFragment.ShenZhenShiFragment;


/**
 * Created by Administrator on 2016/11/11.
 */
public class MySheQuAdapter extends FragmentPagerAdapter {
    private String[] titles = {"热门","深圳市","活动"};
    private Fragment[] fragments = {new HotFragment(),new ShenZhenShiFragment(),new ActivityFragment()};
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public MySheQuAdapter(FragmentManager fm ) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments== null ? 0 : fragments.length;
    }
}