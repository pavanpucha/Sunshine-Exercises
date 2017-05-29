/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.sunshine.data.SunshinePreferences;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        /*
         * Using findViewById, we get a reference to our TextView from xml. This allows us to
         * do things like set the text of the TextView.
         */
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);
        loadWeatherData();
        // TODO (9) Call loadWeatherData to perform the network request to get the weather
    }
private void loadWeatherData(){
    String location = SunshinePreferences.getPreferredWeatherLocation(this);
    new networkAsync().execute(location);
}
    // TODO (8) Create a method that will get the user's preferred location and execute your new AsyncTask and call it loadWeatherData

    // TODO (5) Create a class that extends AsyncTask to perform network requests
    private class networkAsync extends AsyncTask<String,Void,String[]>{
        @Override
        protected String[] doInBackground(String... param){
            if(param.length == 0){
                return null;
            }
            String loc = param[0];
            URL weatherReqURL = NetworkUtils.buildUrl(loc);
            try{
                String JsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherReqURL);
                String[] simpleJsonWeatherData = OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(MainActivity.this,JsonWeatherResponse);
                Log.v("The weather",simpleJsonWeatherData.toString());
                return simpleJsonWeatherData;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            return null;
            }

        }
        protected void onPostExecute(String[] result){
        if(result!=null && !result.equals("")){
            for(String a:result){
            mWeatherTextView.append(a+ "\n\n\n");
        }}
    }
    }
    // TODO (6) Override the doInBackground method to perform your network requests
    // TODO (7) Override the onPostExecute method to display the results of the network request
}