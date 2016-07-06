package jp.ac.titech.itpro.sdl.mealguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


/**
 * Created by yharaguchi on 2016/06/21.
 */
public class WebActivity extends Activity {

    private WebView mWebView;
    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_tab);

        //グローバル変数の取得
        globals = (Globals) this.getApplication();

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.loadUrl(globals.nowUrl);
    }

    public void onClickBack2Button(View v){
        finish();
    }
}
