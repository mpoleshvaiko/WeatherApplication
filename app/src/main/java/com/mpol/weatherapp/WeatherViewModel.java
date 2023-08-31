package com.mpol.weatherapp;

import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    private final VolleySingleton volleySingleton;

    private Disposable disposable;
    private final MutableLiveData<WeatherData> weatherLiveData = new MutableLiveData<>();

    private final MutableLiveData<List<ForecastWeatherData>> forecastLiveData = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isDarkModeLiveData = new MutableLiveData<>();

    @Inject
    public WeatherViewModel(VolleySingleton volleySingleton) {
        this.volleySingleton = volleySingleton;
    }

    public LiveData<Boolean> getCurrentThemeMode() {
        return isDarkModeLiveData;
    }

    public void setCurrentThemeMode(boolean isDarkMode) {
        isDarkModeLiveData.setValue(isDarkMode);
    }

    public LiveData<WeatherData> getWeatherLiveData() {
        return weatherLiveData;
    }

    public LiveData<List<ForecastWeatherData>> getForecastLiveData() {
        return forecastLiveData;
    }

    public void fetchWeatherDataWithInterval() {
        disposable = Observable.interval(0, 1, TimeUnit.MINUTES)
                .flatMap(period -> fetchWeatherData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        pair -> {
                            weatherLiveData.setValue(pair.first);
                            forecastLiveData.setValue(pair.second);
                        },
                        throwable -> Log.e("ERROR", "Error during processing response" + throwable.getMessage())
                );
    }

    public Observable<Pair<WeatherData, List<ForecastWeatherData>>> fetchWeatherData() {
        return Observable.create((ObservableOnSubscribe<JSONObject>) emitter -> {
                    String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                            Request.Method.GET, url, null,
                            emitter::onNext,
                            emitter::onError
                    );

                    volleySingleton.getRequestQueue().add(jsonObjectRequest);
                })
                .flatMap(response -> {
                    try {
                        boolean isDarkMode = isDarkModeLiveData.getValue() != null && isDarkModeLiveData.getValue();
                        WeatherData currentWeather = WeatherResponseMapper.mapResponse(response, isDarkMode);
                        List<ForecastWeatherData> forecastData = WeatherResponseMapper.mapForecastResponse(response, isDarkMode);
                        return Observable.just(new Pair<>(currentWeather, forecastData));
                    } catch (JSONException e) {
                        return Observable.error(e);
                    }
                });
    }

    private void disposeSubscription() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposeSubscription();
    }
}
