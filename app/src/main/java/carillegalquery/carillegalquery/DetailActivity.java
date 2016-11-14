package carillegalquery.carillegalquery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static carillegalquery.carillegalquery.childfragment.childSheQuFragment.ShenZhenShiFragment.CLUBID;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private WebView mWebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();


    }
    public String getUrl(int id){
        String mUrl= "http://saturn.nav.mucang.cn/topic/detail?topicId="+id;
        return mUrl;
    }
    private void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        int topicId = intent.getIntExtra(CLUBID,0);
        Log.e(TAG, "clubId: "+topicId );
        mWebView = (WebView) findViewById(R.id.detail_webView);
        //开启javaScript
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //设置WebView可触摸放大缩小：
        settings.setBuiltInZoomControls(true);
        //WebView双击变大，再双击后变小，当手动放大后，双击可以恢复到原始大小
        settings.setUseWideViewPort(true);
        //加载本地网页
        mWebView.setWebViewClient(new WebViewClient());
        //http://saturn.nav.mucang.cn/topic/detail?topicId=4504852
        if(url!= null && !url.equals("")){
            mWebView.loadUrl(url);
        }else if(topicId > 0){
            mWebView.loadUrl(getUrl(topicId));
        }
    }
}
