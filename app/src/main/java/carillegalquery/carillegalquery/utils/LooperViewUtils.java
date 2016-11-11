package carillegalquery.carillegalquery.utils;

import android.os.Handler;

/**
 * Created by Administrator on 2016/11/11.
 */

public class LooperViewUtils {
    public static final int LOOPVIEW = 1;
    public static void startLooperView(final Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                        handler.sendEmptyMessage(LOOPVIEW);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
