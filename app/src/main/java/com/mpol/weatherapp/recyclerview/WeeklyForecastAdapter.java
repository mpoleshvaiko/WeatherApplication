package com.mpol.weatherapp.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mpol.weatherapp.BR;
import com.mpol.weatherapp.R;
import com.mpol.weatherapp.databinding.WeeklyForecastItemBinding;
import com.mpol.weatherapp.model.WeeklyForecastWeatherData;

import java.util.List;

public class WeeklyForecastAdapter extends RecyclerView.Adapter<WeeklyForecastAdapter.WeeklyForecastViewHolder> {

    private List<WeeklyForecastWeatherData> weeklyForecastList;

    public WeeklyForecastAdapter(List<WeeklyForecastWeatherData> weeklyForecastWeatherData) {
        this.weeklyForecastList = weeklyForecastWeatherData;
    }

    public void setWeeklyForecastList(List<WeeklyForecastWeatherData> weeklyForecastList) {
        this.weeklyForecastList = weeklyForecastList;
    }

    @NonNull
    @Override
    public WeeklyForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeeklyForecastItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.weekly_forecast_item, parent, false);
        return new WeeklyForecastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyForecastViewHolder holder, int position) {
        WeeklyForecastWeatherData weeklyForecast = weeklyForecastList.get(position);
        holder.bind(weeklyForecast);
    }

    @Override
    public int getItemCount() {
        return weeklyForecastList.size();
    }

    static class WeeklyForecastViewHolder extends RecyclerView.ViewHolder {
        public WeeklyForecastItemBinding weeklyForecastItemBinding;

        public WeeklyForecastViewHolder(WeeklyForecastItemBinding weeklyForecastItemBinding) {
            super(weeklyForecastItemBinding.getRoot());
            this.weeklyForecastItemBinding = weeklyForecastItemBinding;
        }

        public void bind(Object object) {
            weeklyForecastItemBinding.setVariable(BR.weeklyForecast, object);
            weeklyForecastItemBinding.executePendingBindings();
        }
    }
}
