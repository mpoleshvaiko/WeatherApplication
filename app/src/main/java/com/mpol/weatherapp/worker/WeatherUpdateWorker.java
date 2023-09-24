package com.mpol.weatherapp.worker;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.hilt.work.HiltWorker;
import androidx.work.Data;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;

import com.mpol.weatherapp.repository.WeatherDataRepository;
import com.mpol.weatherapp.util.SerializationUtils;

import java.net.UnknownHostException;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;


@HiltWorker
public class WeatherUpdateWorker extends RxWorker {

    private final WeatherDataRepository weatherDataRepository;

    @AssistedInject
    public WeatherUpdateWorker(
            @Assisted @NonNull Context appContext,
            @Assisted @NonNull WorkerParameters workerParams,
            WeatherDataRepository weatherDataRepository
    ) {
        super(appContext, workerParams);
        this.weatherDataRepository = weatherDataRepository;
    }

    @NonNull
    @Override
    public Single<Result> createWork() {
        Log.d("WeatherUpdateWorker", "Worker started");
        try {
            return Single.zip(
                    weatherDataRepository.getCurrentWeatherData().firstOrError().subscribeOn(Schedulers.io()),
                    weatherDataRepository.getHourlyForecastWeatherData().firstOrError().subscribeOn(Schedulers.io()),
                    weatherDataRepository.getWeeklyForecastWeatherData().firstOrError().subscribeOn(Schedulers.io()),
                    (currentWeather, hourlyForecast, weeklyForecast) -> {
                        String currentWeatherSerialized = SerializationUtils.serialize(currentWeather);
                        String hourlyForecastSerialized = SerializationUtils.serialize(hourlyForecast);
                        String weeklyForecastSerialized = SerializationUtils.serialize(weeklyForecast);

                        Data.Builder dataBuilder = new Data.Builder()
                                .putString("currentWeather", currentWeatherSerialized)
                                .putString("hourlyForecast", hourlyForecastSerialized)
                                .putString("weeklyForecast", weeklyForecastSerialized);

                        Log.d("WeatherUpdateWorker", "Worker completed successfully");
                        return Result.success(dataBuilder.build());
                    }
            );

        } catch (Exception e) {
            if (isNetworkError(e)) {
                Log.e("WeatherUpdateWorker", "Network Error" + e.getMessage());
                return Single.just(Result.retry());
            } else {
                Log.e("WeatherUpdateWorker", "Error" + e.getMessage());
                return Single.just(Result.failure());
            }
        }
    }

    private boolean isNetworkError(Throwable throwable) {
        while (throwable != null) {
            if (throwable instanceof UnknownHostException) {
                return true;
            }
            throwable = throwable.getCause();
        }
        return false;
    }
}
