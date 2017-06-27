package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private String newStr;
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextView = (TextView)findViewById(R.id.getIntentText);
        Intent i = getIntent();
        if(i != null){
            if(i.hasExtra(Intent.EXTRA_TEXT)){
                newStr = i.getStringExtra(Intent.EXTRA_TEXT);
                mTextView.setText(newStr);
            }
        }
        // TODO (2) Display the weather forecast that was passed from MainActivity
    }
}