package com.example.findtheword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class FinalResults extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_results);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		
		getWindow().setLayout((int)(width*.8), (int)(height*.6));
		
		Intent intent = getIntent();
        String rightAnswers = intent.getStringExtra(CheckWords.EXTRA_RIGHT_ANSWERS);
        TextView textView1 = (TextView)findViewById(R.id.rightAnswersNrTextView);
        textView1.setText(rightAnswers);
        
        String wrongAnswers = intent.getStringExtra(CheckWords.EXTRA_WRONG_ANSWERS);
        TextView textView2 = (TextView)findViewById(R.id.wrongAnswersNrTextView);
        textView2.setText(wrongAnswers);
        
        String finalScore = intent.getStringExtra(CheckWords.EXTRA_FINAL_SCORE);        
        TextView textView3 = (TextView)findViewById(R.id.finalScoreNrTextView);
        textView3.setText(finalScore);		
        
        ImageButton backToMenuButton = (ImageButton) findViewById(R.id.backToMenuButton);
        
        backToMenuButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FinalResults.this, StartActivity.class);
				startActivity(intent);				
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
}
