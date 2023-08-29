package com.mpol.weatherapp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    private final VolleySingleton volleySingleton;
    private final MutableLiveData<WeatherData> weatherLiveData = new MutableLiveData<>();

    private Disposable disposable;

    private MutableLiveData<Boolean> isDarkModeLiveData = new MutableLiveData<>();

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

    public void fetchWeatherData() {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                this::handleResponse,
                error -> Log.e("ERROR", "error while fetching data ->" + error.getMessage())
        );
        volleySingleton.getRequestQueue().add(jsonObjectRequest);
    }

    private void handleResponse(JSONObject response) {
        if (response != null) {
            disposable = Observable.fromCallable(() -> WeatherResponseMapper.mapResponse(response, isDarkModeLiveData.getValue()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            weatherLiveData::setValue,
                            throwable -> Log.e("ERROR", "Error during processing response" + throwable.getMessage())
                    );
        }
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
