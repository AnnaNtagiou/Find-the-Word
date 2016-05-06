package com.example.findtheword;

import java.text.DecimalFormat;
import java.util.Arrays;

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

public class CheckWords extends Activity {
	
	int index = 0;
	int rightAnswers=0;
	int wrongAnswers=0;
	public final static String EXTRA_RIGHT_ANSWERS = "com.example.findtheword.RIGHT_ANSWERS";
	public final static String EXTRA_WRONG_ANSWERS = "com.example.findtheword.WRONG_ANSWERS";
	public final static String EXTRA_FINAL_SCORE = "com.example.findtheword.FINAL_SCORE";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_words);
		
		Resources res = getResources();
		final String[] firstRoundWords = res.getStringArray(R.array.first_round);
		final String[] firstRoundCheckWords = res.getStringArray(R.array.first_round_check);
		
		final TextView textView = (TextView) findViewById(R.id.wordTextView);
		textView.setText(String.valueOf(firstRoundCheckWords[index]));
		
		ImageButton seenButton = (ImageButton) findViewById(R.id.seenButton);
		ImageButton unseenButton = (ImageButton) findViewById(R.id.unseenButton);
		
		seenButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Arrays.asList(firstRoundWords).contains(firstRoundCheckWords[index])) 
				{
				    rightAnswers++;
				}
				else
				{
					wrongAnswers++;
				}
				if(index < firstRoundCheckWords.length-1)
				{
					index++;
					textView.setText(String.valueOf(firstRoundCheckWords[index]));					
				}
				else
				{
					Intent intent = new Intent(CheckWords.this, FinalResults.class);
					
	        		double finalScore = (double)rightAnswers/(rightAnswers+wrongAnswers);
	        		DecimalFormat df = new DecimalFormat("#.00");
	        		
	        		String rightAnswersStr = Integer.toString(rightAnswers);
					String wrongAnswersStr = Integer.toString(wrongAnswers);
					String finalScoreStr = df.format(finalScore*100);
					
	        		finalScoreStr += " %";
					
					intent.putExtra(EXTRA_RIGHT_ANSWERS, rightAnswersStr );
	        		intent.putExtra(EXTRA_WRONG_ANSWERS, wrongAnswersStr );
	        		intent.putExtra(EXTRA_FINAL_SCORE, finalScoreStr );
					startActivity(intent);
				}
			}
		});	
		
		unseenButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Arrays.asList(firstRoundWords).contains(firstRoundCheckWords[index])) 
				{
					wrongAnswers++;
				}
				else
				{
					rightAnswers++;
				}
				if(index < firstRoundCheckWords.length-1)
				{
					index++;
					textView.setText(String.valueOf(firstRoundCheckWords[index]));
					
				}
				else
				{
					Intent intent = new Intent(CheckWords.this, FinalResults.class);
					
	        		double finalScore = (double)rightAnswers/(rightAnswers+wrongAnswers);
	        		DecimalFormat df = new DecimalFormat("#.00");
	        		
	        		String rightAnswersStr = Integer.toString(rightAnswers);
					String wrongAnswersStr = Integer.toString(wrongAnswers);
					String finalScoreStr = df.format(finalScore*100);					
	        		finalScoreStr += " %";
					
					intent.putExtra(EXTRA_RIGHT_ANSWERS, rightAnswersStr );
	        		intent.putExtra(EXTRA_WRONG_ANSWERS, wrongAnswersStr );
	        		intent.putExtra(EXTRA_FINAL_SCORE, finalScoreStr );
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
		getMenuInflater().inflate(R.menu.check_words, menu);
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
