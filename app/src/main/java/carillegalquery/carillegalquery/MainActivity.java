package carillegalquery.carillegalquery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import carillegalquery.carillegalquery.fragment.HomeFragment;
import carillegalquery.carillegalquery.fragment.SheQuFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        showFragments(0);


        //全忘了看人家了情况为二级
    }

    private void initView() {



        //起来就去了会计案例
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        ((RadioButton) rg_main.getChildAt(0)).setChecked(true);
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < group.getChildCount(); i++) {
                    if (group.getChildAt(i).getId() == checkedId) {
                        showFragments(i);
                        break;
                    }
                }
            }
        });
    }

    private int lastIndex = -1;
    private Fragment[] fragments = new Fragment[5];

    private void showFragments(int currentIndex) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (lastIndex != -1) {
            ft.hide(fragments[lastIndex]);
        }
        if (fragments[currentIndex] == null) {
            switch (currentIndex) {
                case 0:
                    fragments[currentIndex] = new HomeFragment();
                    break;
                case 1:
                    fragments[currentIndex] = new HomeFragment();
                    break;
                case 2:
                    fragments[currentIndex] = new HomeFragment();
                    break;
                case 3:
                    fragments[currentIndex] = new SheQuFragment();
                    break;
                case 4:
                    fragments[currentIndex] = new HomeFragment();
                    break;
            }
            ft.add(R.id.fl_main, fragments[currentIndex]);
        } else {
            ft.show(fragments[currentIndex]);
        }
//        ft.commit();
        //提交允许状态丢失
        ft.commitAllowingStateLoss();
        lastIndex = currentIndex;
    }
}
