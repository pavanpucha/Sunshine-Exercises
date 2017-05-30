package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by pavan on 5/30/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    public void ForecastAdapter() {

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }
// TODO (24) Override onCreateViewHolder
    // completed  Within onCreateViewHolder, inflate the list item xml into a view
    // Completed Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter


    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);

    }
    // COMPLETED Override onBindViewHolder
    // COMPLETED Set the text of the TextView to the weather for this list item's position

    // COMPLETED Override getItemCount
    // COMPLETEd Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    // COMPLETED Create a setWeatherData method that saves the weatherData to mWeatherData
    // COMPLETEd After you save mWeatherData, call notifyDataSetChanged
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder viewHolder, int position){

        viewHolder.mWeatherTextView.setText(mWeatherData[position]);

    }
    @Override
    public int  getItemCount()
    {
        if(mWeatherData == null){
            return 0;
        }
        else
            return mWeatherData.length;
    }
    private void setWeatherData(String[] weatherData){
        weatherData = mWeatherData;
        notifyDataSetChanged();
    }
}
