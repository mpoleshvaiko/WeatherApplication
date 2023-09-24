package com.mpol.weatherapp.repository;


import com.mpol.weatherapp.api.WeatherApiService;
import com.mpol.weatherapp.mapper.WeatherResponseMapper;
import com.mpol.weatherapp.model.DayWeatherData;
import com.mpol.weatherapp.model.HourlyForecastWeatherData;
import com.mpol.weatherapp.model.WeeklyForecastWeatherData;

import org.json.JSONException;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class WeatherDataRepositoryImpl implements WeatherDataRepository {
    private final WeatherApiService weatherApiService;

    @Inject
    public WeatherDataRepositoryImpl(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @Override
    public Observable<DayWeatherData> getCurrentWeatherData() {
        return Observable.create(emitter -> weatherApiService.getWeatherData(
                response -> {
                    try {
                        emitter.onNext(WeatherResponseMapper.mapDayResponse(response));
                    } catch (JSONException e) {
                        emitter.onError(e);
                    }
                },
                emitter::onError
        ));
    }

    @Override
    public Observable<List<HourlyForecastWeatherData>> getHourlyForecastWeatherData() {
        return Observable.create(emitter -> weatherApiService.getHourlyForecast(
                response -> {
                    try {
                        emitter.onNext(WeatherResponseMapper.mapHourlyForecastResponse(response));
                    } catch (JSONException e) {
                        emitter.onError(e);
                    }
                },
                emitter::onError
        ));
    }

    @Override
    public Observable<List<WeeklyForecastWeatherData>> getWeeklyForecastWeatherData() {
        return Observable.create(emitter -> weatherApiService.getWeeklyForecast(
                response -> {
                    try {
                        emitter.onNext(WeatherResponseMapper.mapWeeklyForecastResponse(response));
                    } catch (JSONException e) {
                        emitter.onError(e);
                    }
                },
                emitter::onError
        ));
    }
}
