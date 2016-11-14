package carillegalquery.carillegalquery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.loopj.android.http.AsyncHttpClient;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView web_view;
    private int id;
    private AsyncHttpClient asyncHttpClient;
    private Toolbar web_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {
        web_toolbar = (Toolbar) findViewById(R.id.web_toolbar);
        web_toolbar.setTitle("");
        setSupportActionBar(web_toolbar);
        web_view = (WebView) findViewById(R.id.web_view);
        findViewById(R.id.iv_back).setOnClickListener(this);
//        web_toolbar = (Toolbar) findViewById(R.id.web_toolbar);
//        web_toolbar.setTitle("");
//        setSupportActionBar(web_toolbar);
//        findViewById(R.id.iv_share).setOnClickListener(this);
//        findViewById(R.id.iv_collect).setOnClickListener(this);
//        findViewById(R.id.iv_back).setOnClickListener(this);


        web_view.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        web_view.getSettings().setBuiltInZoomControls(true);
        web_view.getSettings().setJavaScriptEnabled(true); // 设置JavaScript可用
        web_view.setWebChromeClient(new WebChromeClient()); // 处理JavaScript对话框
        web_view.setWebViewClient(new WebViewClient()); // 处理各种通知和请求事件，如果不使用该句代码，将使用内置浏览器访问网页

        id = getIntent().getIntExtra("id", 100);
        web_view.loadUrl(getUrl(id));

    }


    public String getUrl(int id2) {
        String url = "http://saturn.nav.mucang.cn/topic/detail?topicId=" + id2;
        String substring = url.substring(url.indexOf("?"), url.length());
        if ("topicId".equals(substring)) {
            url = "http://saturn.nav.mucang.cn/topic/detail?topicId=" + id2;
        } else if ("clubId".equals(substring)) {
            url = "http://saturn.nav.mucang.cn/topic/detail?clubId=" + id2;
        }
        return url;
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
