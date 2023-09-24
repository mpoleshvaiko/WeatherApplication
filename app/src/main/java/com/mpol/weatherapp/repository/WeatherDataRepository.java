package com.mpol.weatherapp.repository;

import com.mpol.weatherapp.model.DayWeatherData;
import com.mpol.weatherapp.model.HourlyForecastWeatherData;
import com.mpol.weatherapp.model.WeeklyForecastWeatherData;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public interface WeatherDataRepository {
    Observable<DayWeatherData> getCurrentWeatherData();

    Observable<List<HourlyForecastWeatherData>> getHourlyForecastWeatherData();

    Observable<List<WeeklyForecastWeatherData>> getWeeklyForecastWeatherData();
}
