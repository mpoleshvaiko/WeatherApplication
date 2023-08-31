package com.mpol.weatherapp.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mpol.weatherapp.BR;
import com.mpol.weatherapp.R;
import com.mpol.weatherapp.databinding.HourlyForecastItemBinding;
import com.mpol.weatherapp.model.ForecastWeatherData;

import java.util.List;

public class HourlyForecastAdapter extends RecyclerView.Adapter<HourlyForecastAdapter.ForecastViewHolder> {

    private List<ForecastWeatherData> forecastList;

    public HourlyForecastAdapter(List<ForecastWeatherData> forecastList) {
        this.forecastList = forecastList;
    }

    public void setForecastList(List<ForecastWeatherData> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public HourlyForecastAdapter.ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HourlyForecastItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.hourly_forecast_item, parent, false);
        return new ForecastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        ForecastWeatherData forecast = forecastList.get(position);
        holder.bind(forecast);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        public HourlyForecastItemBinding hourlyForecastItemBinding;

        public ForecastViewHolder(HourlyForecastItemBinding hourlyForecastItemBinding) {
            super(hourlyForecastItemBinding.getRoot());
            this.hourlyForecastItemBinding = hourlyForecastItemBinding;
        }

        public void bind(Object object) {
            hourlyForecastItemBinding.setVariable(BR.forecast, object);
            hourlyForecastItemBinding.executePendingBindings();
        }
    }
}
