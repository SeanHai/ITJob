package com.job.activity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.job.R;
import com.job.base.BaseActivity;


public class StartActivity extends BaseActivity {

	private static final int FAILURE = 0; // 失败 
    private static final int SUCCESS = 1; // 成功 
    private static final int OFFLINE = 2; // 如果支持离线阅读，进入离线模式 
    private static final int SHOW_TIME_MIN = 1000;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		new AsyncTask<Void, Void, Integer>() {

			@Override
			protected Integer doInBackground(Void... params) {
				int result;
				long startTime = System.currentTimeMillis(); 

				result = loadingCache();
				long loadingTime = System.currentTimeMillis() - startTime; 
				 if (loadingTime < SHOW_TIME_MIN) { 
		                try { 
		                    Thread.sleep(SHOW_TIME_MIN - loadingTime); 
		                } catch (InterruptedException e) { 
		                    e.printStackTrace(); 
		                } 
		            } 
		        
				return result;
			}

			@Override
			protected void onPostExecute(Integer result) {
				Intent intent = new Intent(StartActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				
			}
			
			
			
		}.execute(new Void[]{});
	}

	protected int loadingCache() {
		 

		return 0;
	}
}

