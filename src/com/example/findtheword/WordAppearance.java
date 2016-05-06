package com.example.findtheword;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class WordAppearance extends Activity {
	
	int index = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_appearance);
		
		Resources res = getResources();
		final String[] firstRoundWords = res.getStringArray(R.array.first_round);
		
		
		
		final TextView textView = (TextView) findViewById(R.id.wordTextView);
		textView.setText(String.valueOf(firstRoundWords[index]));
		
		ImageButton nextWordButton = (ImageButton) findViewById(R.id.nextWordButton);
		
		nextWordButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(index < firstRoundWords.length-1)
				{
					index++;
					textView.setText(String.valueOf(firstRoundWords[index]));
				}
				else
				{
					Intent intent = new Intent(WordAppearance.this, CheckPoint.class);
					startActivity(intent);
				}
			}
		});		
	}
	
	@Override
	public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_appearance, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
