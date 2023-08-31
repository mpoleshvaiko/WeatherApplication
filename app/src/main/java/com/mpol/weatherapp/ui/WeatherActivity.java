package com.mpol.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;

import com.mpol.weatherapp.databinding.ActivityWeatherBinding;
import com.mpol.weatherapp.recyclerview.HourlyForecastAdapter;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherActivity extends AppCompatActivity {

    private WeatherViewModel viewModel;
    private ActivityWeatherBinding binding;

    private HourlyForecastAdapter hourlyForecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hourlyForecastAdapter = new HourlyForecastAdapter(new ArrayList<>());
        binding.setHourlyForecastAdapter(hourlyForecastAdapter);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        viewModel.setCurrentThemeMode(isDarkMode());
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.fetchWeatherDataWithInterval();
        populateRecyclerView();
    }

    private boolean isDarkMode() {
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
    }

    private void populateRecyclerView() {
        viewModel.getHourlyForecastLiveData().observe(this, forecastWeatherData ->
                hourlyForecastAdapter.setForecastList(forecastWeatherData));
    }
}