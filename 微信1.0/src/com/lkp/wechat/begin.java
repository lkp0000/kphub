package com.lkp.wechat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

public class begin extends Activity {
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO �Զ����ɵķ������
	super.onCreate(savedInstanceState);
	setContentView(R.layout.welcome);
	final Intent intent = new Intent();
	intent.setClass(begin.this, MainActivity.class);
	
	new CountDownTimer(2000, 1000) {//����д�ӳٵ�����
		  @Override
		  public void onTick(long millisUntilFinished) {
		  }
		  
		  @Override
		  public void onFinish() {
		    //������д��ת���
				startActivity(intent);
				begin.this.finish();
		  }
		}.start();

}

}
