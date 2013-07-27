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
import android.widget.EditText;
import android.widget.TextView;

public class Play extends Activity {
	public final static String TEXT="com.example.encryptodecrypto";
	String[] words = {"apple","orange","banana"};
	int chosen = (int) (Math.random() * (words.length - 1));
	String chosen_word = words[chosen];
	char[] word_array = chosen_word.toCharArray();
	char[] letters_guessed = new char[100];
	Button go;
	int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		TextView word = (TextView) findViewById(R.id.word);
		String new_word = new String();
		for(int l=0;l<chosen_word.length();l++)
		{
			new_word = new_word.concat(" _ ");
		}
		word.setText(new_word);
		go = (Button) findViewById(R.id.go);
		go.setOnClickListener(go_func);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	
	View.OnClickListener go_func = new View.OnClickListener() {
		
		
		
		@Override
		public void onClick(View arg0) {
			EditText temp1 = (EditText) findViewById(R.id.letter_guessed);
			String letter_guessed = temp1.getText().toString();
			TextView temp2 = (TextView) findViewById(R.id.status);
			TextView temp3 = (TextView) findViewById(R.id.word);
			TextView temp4 = (TextView) findViewById(R.id.chances);
			String current_word = new String();
			if(letter_guessed.length()!=1)
			{
				temp2.setText("Please enter only a single letter!");
				for(int j=0;j<chosen_word.length();j++)
				{
					int counter = 0;
					for(int k=0;k<letters_guessed.length;k++)
					{	
						if(letters_guessed[k] == word_array[j])
						{
							current_word = current_word.concat(" ");
							current_word = current_word +(word_array[j]);
							current_word = current_word.concat(" ");
							counter = 1;
						}
					}
					if(counter == 0)
					{
						current_word= current_word.concat(" _ ");
					}
				}
				temp3.setText(current_word);
			}
			else
			{
				char[] letter = letter_guessed.toCharArray();
				letter[0] = Character.toLowerCase(letter[0]);
				if(Character.isLetter(letter[0]))
				{
					int flag = 0;
					for(int j=0;j<letters_guessed.length;j++)
					{
						if(letters_guessed[j] == letter[0])
						{
							temp2.setText("Letter already guessed!");
							flag = 1;
							for( int m=0;m<chosen_word.length();m++)
							{
								int counter = 0;
								for(int k=0;k<letters_guessed.length;k++)
								{	
									if(letters_guessed[k] == word_array[m])
									{
										current_word = current_word.concat(" ");
										current_word = current_word +(word_array[m]);
										current_word = current_word.concat(" ");
										counter = 1;
									}
								}
								if(counter == 0)
								{
									current_word= current_word.concat(" _ ");
								}
							}
							temp3.setText(current_word);
							break;
						}
					}
					if(flag == 0)
					{
						letters_guessed[i] = letter[0];
						i = i + 1;
						int check = 0;
						for(int k=0;k<word_array.length;k++)
						{
							if(letter[0] == word_array[k])
							{
								temp2.setText("Correct guess!");
								check = 1;
							}
						}
						if(check == 0)
						{
							temp2.setText("Wrong guess!");
							String chances = temp4.getText().toString();
							char[] temp_chances = chances.toCharArray();
							int left = (int) temp_chances[temp_chances.length - 1];
							if(left == 0)
								left = 0;
							else
								left = left - 1;
							left = left - 48;
							temp4.setText("Wrong chances left: "+ (left));
							chances = temp_chances.toString();
							
						}
						
						for(int j=0;j<chosen_word.length();j++)
						{
							int counter = 0;
							for(int k=0;k<letters_guessed.length;k++)
							{	
								if(letters_guessed[k] == word_array[j])
								{
									current_word = current_word.concat(" ");
									current_word = current_word +(word_array[j]);
									current_word = current_word.concat(" ");
									counter = 1;
								}
							}
							if(counter == 0)
							{
								current_word= current_word.concat(" _ ");
							}
						}
						
					}
					temp3.setText(current_word);
				}
				
				else
				{
					temp2.setText("Please enter only a single letter!");	
				}
				
				
			}
			int win=1;
			for(int i=0;i<current_word.length();i++)
			{
				if(current_word.charAt(i) == '_')
				{
					win=0;
				}
			}
			
			if(win == 1)
			{
				Intent intent = new Intent(Play.this,Congrats.class);
				TextView score = (TextView) findViewById(R.id.chances);
				String user_score = score.getText().toString();
				intent.putExtra(TEXT,user_score);
				startActivity(intent);
			}
			
			
			
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
		getMenuInflater().inflate(R.menu.play, menu);
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
