package com.axic.ordermanager.activity;

import com.axic.ordermanager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Welcome extends Activity {

	private ImageView welcomeImg = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcomeimg);
		
		welcomeImg = (ImageView) findViewById(R.id.welcome_img);
		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(2500);
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
}
