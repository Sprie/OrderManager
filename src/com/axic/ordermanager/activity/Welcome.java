package com.axic.ordermanager.activity;

import com.axic.ordermanager.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends Activity {

	TextView vs;
	private ImageView welcomeImg = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcomeimg);
		//启动页面显示版本名
		vs = (TextView) findViewById(R.id.version);
		vs.setText("version " + getVersion());
		
		welcomeImg = (ImageView) findViewById(R.id.welcome_img);
		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(3000);
		welcomeImg.startAnimation(anima);
		anima.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				welcomeImg.setBackgroundResource(R.drawable.welcome);
				
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Welcome.this, AddDataToGoods.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
	//获取版本号
	public String getVersion() {
		try {
			PackageInfo pi = 
					this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
			return pi.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return this.getString(R.string.version_unknown);
		}
	}
}
