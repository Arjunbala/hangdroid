package com.example.hangman;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;




@SuppressWarnings("unused")
public class MainActivity extends Activity {
	
	/*public static final String KEY_NAME = "_date";
	public static final String KEY_SCORE = "_time";
	private static final String DATABASE_NAME = "HighScores";
	private static final String DATABASE_TABLE = "HighScores";
	private static final int DATABASE_VERSION = 1;

	private static DbHelper ourHelper;
	private static Context ourContext;
	private static SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_NAME + " (" + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_SCORE + " NUMBER, " 
			);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);

		}

	}

	public MainActivity(Context c) {
		ourContext = c;
	}
	
	
	public MainActivity open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase= ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}


	public static long createEntry(String name, String score) {
		// TODO Auto-generated method stub
		
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_SCORE, score);
		 return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}*/
	
	public final static String data = "com.example.hangman";
	Button play;
	Button instructions;
	Button highscores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button) findViewById(R.id.play);
        instructions = (Button) findViewById(R.id.instructions);
        highscores = (Button) findViewById(R.id.high_scores);
        play.setOnClickListener(play_func);
        instructions.setOnClickListener(instructions_func);
        highscores.setOnClickListener(highscores_func);
    }
    
    View.OnClickListener play_func = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(MainActivity.this,Play.class);
			startActivity(intent);
		}
	};
	
	View.OnClickListener instructions_func = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(MainActivity.this,Instructions.class);
			startActivity(intent);
			
		}
	};
	
	View.OnClickListener highscores_func = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,HighScores.class);
			startActivity(intent);
		}
	};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
