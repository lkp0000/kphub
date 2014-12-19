package com.lkp.wechat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

public class begin extends Activity {
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	setContentView(R.layout.welcome);
	final Intent intent = new Intent();
	intent.setClass(begin.this, MainActivity.class);
	
	new CountDownTimer(2000, 1000) {//这里写延迟的秒数
		  @Override
		  public void onTick(long millisUntilFinished) {
		  }
		  
		  @Override
		  public void onFinish() {
		    //在这里写跳转语句
				startActivity(intent);
				begin.this.finish();
		  }
		}.start();

}

}
