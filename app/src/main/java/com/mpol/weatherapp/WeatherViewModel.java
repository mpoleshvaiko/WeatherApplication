package com.mpol.weatherapp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    private final VolleySingleton volleySingleton;
    private final MutableLiveData<WeatherModel> weatherLiveData = new MutableLiveData<>();

    @Inject
    public WeatherViewModel(VolleySingleton volleySingleton) {
        this.volleySingleton = volleySingleton;
    }

    public LiveData<WeatherModel> getWeatherLiveData() {
        return weatherLiveData;
    }

    public void fetchWeatherData() {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> Observable.fromCallable(() -> processResponse(response))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                weatherLiveData::setValue,
                                throwable -> Log.e("ERROR IN RX", "Error during processing response" + throwable.getMessage())
                        ), error -> Log.e("ERROR", "error while fetching data ->" + error.getMessage()));
        volleySingleton.getRequestQueue().add(jsonObjectRequest);
    }

    private WeatherModel processResponse(JSONObject response) throws JSONException {
        String temperature = response.getJSONObject("current").getString("temp_c");
        String localTime = response.getJSONObject("location").getString("localtime");
        String icon = response.getJSONObject("current").getJSONObject("condition").getString("icon");
        String iconText = response.getJSONObject("current").getJSONObject("condition").getString("text");
        String windSpeed = response.getJSONObject("current").getString("wind_mph");
        String humidity = response.getJSONObject("current").getString("humidity");

        return new WeatherModel(localTime, temperature, icon, iconText, windSpeed, humidity);
    }
}
