package com.mpol.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.mpol.weatherapp.databinding.ActivityWeatherBinding;
import com.mpol.weatherapp.recyclerview.HourlyForecastAdapter;
import com.mpol.weatherapp.recyclerview.WeeklyForecastAdapter;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherActivity extends AppCompatActivity {

    private WeatherViewModel viewModel;
    private ActivityWeatherBinding binding;

    private HourlyForecastAdapter hourlyForecastAdapter;

    private WeeklyForecastAdapter weeklyForecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hourlyForecastAdapter = new HourlyForecastAdapter(new ArrayList<>());
        binding.setHourlyForecastAdapter(hourlyForecastAdapter);
        weeklyForecastAdapter = new WeeklyForecastAdapter(new ArrayList<>());
        binding.setWeeklyForecastAdapter(weeklyForecastAdapter);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.fetchWeatherDataWithInterval();
        viewModel.fetchWeeklyForecastDataWithInterval();
        populateHourlyRecyclerView();
        populateWeeklyRecyclerView();
    }

    private void populateHourlyRecyclerView() {
        viewModel.getHourlyForecastLiveData().observe(this, forecastWeatherData -> {
            hourlyForecastAdapter.setForecastList(forecastWeatherData);
            hourlyForecastAdapter.notifyDataSetChanged();
        });
    }

    private void populateWeeklyRecyclerView() {
        viewModel.getWeeklyForecastLiveData().observe(this, weeklyForecastWeatherData -> {
            weeklyForecastAdapter.setWeeklyForecastList(weeklyForecastWeatherData);
            weeklyForecastAdapter.notifyDataSetChanged();
        });
    }
}