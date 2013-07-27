package com.example.hangman;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.hardware.*;
public class Congrats extends Activity {
	Button score;
	protected CharSequence score_display;
	int num;
	int score_to_display;
	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String score_user = intent.getStringExtra(Play.TEXT);
		num = score_user.charAt(score_user.length()-1);
		num = num - 48;
		score_to_display = num * 1000;
		score_display = score_user;
		setContentView(R.layout.activity_congrats);
		score=(Button) findViewById(R.id.get_score);
		score.setOnClickListener(score_func);
		
		
		/*String text="Wrong chances left: 7";
		int num = 7;
		for(int i=0;i<text.length();i++)
		{
			if(Character.isDigit(text.charAt(i)))
			{
				num = (int) text.charAt(i);
			}
		}
		int score = num * 1000;
		TextView user_score = (TextView) findViewById(R.id.user_score);
		user_score.setText(score);*/
		// Show the Up button in the action bar.
		setupActionBar();
	}
	
	View.OnClickListener score_func = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			//char[] temp = score_display.toCharArray();
			char num = 0;
			
			/*for(int i=0;i<score_display.length();i++)
			{
				if(Character.isDigit(score_display.charAt(i)))
				{
					 num = score_display.charAt(i);
				}
			}*/
			/*char[] temp = score_display.toCharArray();
			num = temp[temp.length - 1];
			int score_disp = num * 1000;
			String final_score = ("Score:"+score_disp);*/
			TextView user_score = (TextView) findViewById(R.id.user_score);
			user_score.setText(" "+score_to_display);
			
		}
	};

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.congrats, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
