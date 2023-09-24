package com.mpol.weatherapp.ui;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.mpol.weatherapp.model.DayWeatherData;
import com.mpol.weatherapp.model.HourlyForecastWeatherData;
import com.mpol.weatherapp.model.WeeklyForecastWeatherData;
import com.mpol.weatherapp.util.SerializationUtils;
import com.mpol.weatherapp.worker.WeatherUpdateWorker;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {
    private final WorkManager workManager;
    private final MutableLiveData<DayWeatherData> dayWeatherLiveData = new MutableLiveData<>();

    private final MutableLiveData<List<HourlyForecastWeatherData>> hourlyForecastLiveData = new MutableLiveData<>();

    private final MutableLiveData<List<WeeklyForecastWeatherData>> weeklyForecastLiveData = new MutableLiveData<>();

    @Inject
    public WeatherViewModel(WorkManager workManager) {
        this.workManager = workManager;
    }

    public LiveData<DayWeatherData> getDayWeatherLiveData() {
        return dayWeatherLiveData;
    }

    public LiveData<List<HourlyForecastWeatherData>> getHourlyForecastLiveData() {
        return hourlyForecastLiveData;
    }

    public LiveData<List<WeeklyForecastWeatherData>> getWeeklyForecastLiveData() {
        return weeklyForecastLiveData;
    }


    public LiveData<WorkInfo> weatherWorkInfoLiveData() {
        OneTimeWorkRequest weatherUpdateWorkRequest =
                new OneTimeWorkRequest.Builder(WeatherUpdateWorker.class).build();
        workManager.enqueue(weatherUpdateWorkRequest);
        return workManager.getWorkInfoByIdLiveData(weatherUpdateWorkRequest.getId());
    }

    public void setWeatherData(WorkInfo workInfo) {
        if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {
            Data outputData = workInfo.getOutputData();
            String currentWeatherJson = outputData.getString("currentWeather");
            dayWeatherLiveData.setValue(SerializationUtils.deserialize(currentWeatherJson, DayWeatherData.class));

            String hourlyWeatherJson = outputData.getString("hourlyForecast");
            hourlyForecastLiveData.setValue(SerializationUtils.deserializeList(hourlyWeatherJson, HourlyForecastWeatherData.class));

            String weeklyWeatherJson = outputData.getString("weeklyForecast");
            weeklyForecastLiveData.setValue(SerializationUtils.deserializeList(weeklyWeatherJson, WeeklyForecastWeatherData.class));
        }
    }
}
