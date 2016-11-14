package carillegalquery.carillegalquery.childfragment.childSheQuFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import carillegalquery.carillegalquery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {


    private View mViewPager;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.hot_recyclerView);
// 下文翻译:RecyclerView的尺寸在每次改变时，比如你加任何些东西。
// setHasFixedSize 的作用就是确保尺寸是通过用户输入
// 从而确保RecyclerView的尺寸是一个常数。
// RecyclerView 的Item宽或者高不会变。每一个Item添加或者删除都不会变。
// 如果你没有设置setHasFixedSized没有设置的代价将会是非常昂贵的。
// 因为RecyclerView会需要而外计算每个item的size，
        recyclerView.setHasFixedSize(true);
        int spanCount = 1;
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.setAdapter();

    }
}
