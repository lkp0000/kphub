package com.lkp.wechat;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	private TextView mchattext;
	private TextView mfriendtext;
	private TextView mcontacttext;
	private int screen1_3;
	private ImageView mTabline;
	protected int mCurrentPageIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mchattext = (TextView) findViewById(R.id.chattext);
        mfriendtext = (TextView) findViewById(R.id.friendtext);
        mcontacttext = (TextView) findViewById(R.id.contacttext);
        
        
        changetablinemargin();
        
        initview();
    }

	private void changetablinemargin() {
		mTabline = (ImageView) findViewById(R.id.tabfolow);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        screen1_3 = outMetrics.widthPixels/3;
        
        LayoutParams lp=mTabline.getLayoutParams();
        lp.width = screen1_3;
        mTabline.setLayoutParams(lp);
	}

    @Override
	public void onBackPressed() {
    	//MainActivity.this.finish();
		 startdialog();		
	}

	private void startdialog() {
		// TODO �Զ����ɵķ������
		AlertDialog.Builder mdialog = new AlertDialog.Builder(this);
		mdialog.setTitle("��ʾ");
		mdialog.setMessage("ȷ���˳�΢�ţ�");
		mdialog.setPositiveButton("�˳�", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO �Զ����ɵķ������
			dialog.dismiss();
			MainActivity.this.finish();
			}
		});
		mdialog.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO �Զ����ɵķ������
				dialog.dismiss();
			}
		});
		mdialog.create().show();
		
	}

	private void initview() {
		// TODO �Զ����ɵķ������
		mViewPager = (ViewPager) findViewById(R.id.viewPager1);
		mDatas = new ArrayList<Fragment>();
		chatMainTabFragment tap01= new chatMainTabFragment();
		friendMainTabFragment tap02= new friendMainTabFragment();
		contactMainTabFragment tap03= new contactMainTabFragment();
		mDatas.add(tap01);
		mDatas.add(tap02);
		mDatas.add(tap03);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO �Զ����ɵķ������
				return mDatas.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO �Զ����ɵķ������
				return mDatas.get(arg0);
			}
		};
		
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int ofpage) {
				// TODO �Զ����ɵķ������
				resettextcolor();
				switch (ofpage) {
				case 0:	
					mchattext.setTextColor(Color.rgb(50,205,50));
					break;
				case 1:
					mfriendtext.setTextColor(Color.rgb(50,205,50));
					break;
				case 2:
					mcontacttext.setTextColor(Color.rgb(50,205,50));
					break;
				}
				mCurrentPageIndex =ofpage;
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPx) {
				// TODO �Զ����ɵķ������
				LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabline.getLayoutParams();
			if (mCurrentPageIndex ==0 && position == 0) {
			lp.leftMargin = (int) (positionOffset*screen1_3+mCurrentPageIndex*screen1_3);	
			}
			else if (mCurrentPageIndex ==1 && position == 0) {
				lp.leftMargin = (int) ((positionOffset-1)*screen1_3+mCurrentPageIndex*screen1_3);
			}
			else if (mCurrentPageIndex ==1 && position == 1) {
				lp.leftMargin = (int) (positionOffset*screen1_3+mCurrentPageIndex*screen1_3);
			}
			else if (mCurrentPageIndex ==2 && position == 1) {
				lp.leftMargin = (int) ((positionOffset-1)*screen1_3+mCurrentPageIndex*screen1_3);
			}
			
			
			mTabline.setLayoutParams(lp);
			
			
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO �Զ����ɵķ������
				
			}
		});
		
		
    }


	protected void resettextcolor() {
		// TODO �Զ����ɵķ������
		mchattext.setTextColor(Color.BLACK);
		mcontacttext.setTextColor(Color.BLACK);
		mfriendtext.setTextColor(Color.BLACK);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO �Զ����ɵķ������
		getLayoutInflater().setFactory(new Factory() {
			
			@Override
			public View onCreateView(String name, Context context, AttributeSet attrs) {
				// TODO �Զ����ɵķ������
				if(name.equalsIgnoreCase("com.android.internal.view.menu.menu"))
				{
					try{
						
						LayoutInflater f = getLayoutInflater();
						final View view = f.createView(name, null, attrs);
						new Handler().post(new Runnable() {
							
							@Override
							public void run() {
								// TODO �Զ����ɵķ������
								view.setBackgroundResource(R.layout.menulayout);
								
							}
						});
						
					return view;	
					}
					catch(InflateException e){}
					catch (ClassNotFoundException e) {
						// TODO: handle exception
					}
					
					
					
					
				}
				
				return null;
			}
		});
		
		
		return super.onCreateOptionsMenu(menu);
	}*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.tuichumenu) {
        	MainActivity.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	
}
