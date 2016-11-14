package carillegalquery.carillegalquery.adapter.homeadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/11/11/011.
 */

public class MyHomeListView extends ListView {

    public MyHomeListView(Context context) {
        super(context);
    }

    public MyHomeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //通过制定的高度(Integer.MAX_VALUE>>2)和模式来创建一个规格
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
