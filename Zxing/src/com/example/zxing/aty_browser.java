package com.example.zxing;

import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class aty_browser extends Activity {
	private WebView mwebview;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.browser);
	mwebview=(WebView) findViewById(R.id.wv_browser);
	mwebview.getSettings().setJavaScriptEnabled(true);
	mwebview.setWebViewClient(new MyWebViewClient());
	
	Intent qrscan=new Intent(aty_browser.this, CaptureActivity.class);
	startActivityForResult(qrscan, 0);
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if (resultCode==RESULT_OK) {
		String result=data.getExtras().getString("result");
		 
	mwebview.loadUrl(result);
		}
}
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	// TODO Auto-generated method stub
	if ((keyCode==KeyEvent.KEYCODE_BACK)&&mwebview.canGoBack()) {
		mwebview.goBack();
		return true;
	}
	return super.onKeyDown(keyCode, event);
}
private class MyWebViewClient extends WebViewClient{
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		mwebview.loadUrl(url);
		return true;
	}
}
}
/*class MyWebViewClient extends WebViewClient {

    @Override

    public boolean shouldOverrideUrlLoading(WebView view, String url) {

    // 可在这里做一些逻辑操作

           if (openWithWevView(url)) {

              view.loadUrl(url);

           }else{

              Uri uri = Uri.parse(url); //url为你要链接的地址

              Intent intent =new Intent(Intent.ACTION_VIEW, uri);

              startActivity(intent);

           }

           return true;

}

其中openWithWevView(url)是自己写的一个方法，用来判断是否用WevView打开该链接。
*/