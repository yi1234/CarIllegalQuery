package carillegalquery.carillegalquery.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/14/014.
 */

public class MyReceiver extends BroadcastReceiver {
//cc
    private ConnectivityManager mConnectivityManager;
    private NetworkInfo netInfo;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            netInfo = mConnectivityManager.getActiveNetworkInfo(); // 获取网络状态信息
            if (netInfo != null && netInfo.isAvailable()) {//网络状态不能为空，并且是有效的
                String name = netInfo.getTypeName();//得到网络名称。如：wifi
                switch (netInfo.getType()) {//获取网络状态类型 int值
                    case ConnectivityManager.TYPE_WIFI:
                        Toast.makeText(context, "已连接到WiFi网络！", Toast.LENGTH_LONG).show();
                        break;
                    case ConnectivityManager.TYPE_MOBILE:
                        Toast.makeText(context, "正在使用移动网络！", Toast.LENGTH_LONG).show();
                        break;
                    case ConnectivityManager.TYPE_ETHERNET:
                        Toast.makeText(context, "以太网有线网络！", Toast.LENGTH_LONG).show();
                        break;
                }
            } else
                Toast.makeText(context, "网络连接失败！", Toast.LENGTH_LONG).show();
        }
    }
}
