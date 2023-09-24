package com.mpol.weatherapp.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mpol.weatherapp.BuildConfig;

import org.json.JSONObject;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherApiServiceImpl implements WeatherApiService {

    private final VolleySingleton volleySingleton;

    @Inject
    public WeatherApiServiceImpl(VolleySingleton volleySingleton) {
        this.volleySingleton = volleySingleton;
    }

    @Override
    public void getWeatherData(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                successListener,
                errorListener
        );
        volleySingleton.getRequestQueue().add(jsonObjectRequest);
    }

    @Override
    public void getHourlyForecast(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                successListener,
                errorListener
        );
        volleySingleton.getRequestQueue().add(jsonObjectRequest);
    }

    @Override
    public void getWeeklyForecast(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + BuildConfig.API_KEY + "&q=Warsaw&days=7";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                successListener,
                errorListener
        );
        volleySingleton.getRequestQueue().add(jsonObjectRequest);
    }
}
