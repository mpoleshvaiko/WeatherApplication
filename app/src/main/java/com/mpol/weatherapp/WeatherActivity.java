package com.mpol.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherActivity extends AppCompatActivity {

    private WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        setContentView(R.layout.activity_weather);
        getWeather();
    }

    private void getWeather() {
        viewModel.fetchWeatherData();
        viewModel.getWeatherLiveData().observe(this, weatherData ->
                Log.d("WEATHER DATA", "time -> " + weatherData.getLocalTime()
                        + "temperature ->" + weatherData.getCurrentTemperature()
                        + "min temperature -> " + weatherData.getMinTemperature()
                        + "max temperature -> " + weatherData.getMaxTemperature()));
    }
}