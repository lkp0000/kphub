package com.example.upyunthree;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	/*	String jsondata = "{\"name\":\"value\"}";
		try {
			JSONObject jb = new JSONObject(jsondata);
		String name =jb.getString("name");
		System.out.println(name);
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		
		
		
	final	RequestQueue mQueue =Volley.newRequestQueue(this);
		String qianzhui = "http://myserver.b0.upaiyun.com/list/article_test20141225_";
		for(int i=0;i<10;i++){
			String url=qianzhui+i+".json";
			System.out.println(i);
		StringRequest mRequest = new StringRequest(Method.GET,url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				
				// TODO 自动生成的方法存根
				System.out.println(response);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO 自动生成的方法存根
				
			}
		});
		mQueue.add(mRequest);
		}*/
	}
}