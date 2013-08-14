package com.app42sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app42sample.R;
import com.shephertz.app42.paas.sdk.android.App42Activity;

public class SecondActivity extends App42Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        ( (TextView)findViewById(R.id.page_header)).setText("Second Activty");
	    }

	  public void onClick(View view){
		   super.onClick(view);
		   
		   Intent intent=new Intent(this,ThirdActivity.class);
		   startActivity(intent);
		  
	   }
	   public void onStart() {
			super.onStart();
			
			 
		
		}

		/*
		 * * This method is called when a Activty is stop disable all the events if
		 * occuring (non-Javadoc)
		 * 
		 * @see android.app.Activity#onStop()
		 */
		public void onStop() {
			super.onStop();
			
			

		}

		/*
		 * This method is called when a Activty is finished or user press the back
		 * button (non-Javadoc)
		 * 
		 * @override method of superclass
		 * 
		 * @see android.app.Activity#onDestroy()
		 */
		public void onDestroy() {
			super.onDestroy();
			
		}

		/*
		 * called when this activity is restart again
		 * 
		 * @override method of superclass
		 */
		public void onReStart() {
			super.onRestart();
			
		}

		/*
		 * called when activity is paused
		 * 
		 * @override method of superclass (non-Javadoc)
		 * 
		 * @see android.app.Activity#onPause()
		 */
		public void onPause() {
			super.onPause();
			
		}

		/*
		 * called when activity is resume
		 * 
		 * @override method of superclass (non-Javadoc)
		 * 
		 * @see android.app.Activity#onResume()
		 */
		public void onResume() {
			super.onResume();
			
		}
}
