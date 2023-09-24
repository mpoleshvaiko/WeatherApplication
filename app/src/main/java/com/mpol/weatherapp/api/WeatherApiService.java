package com.mpol.weatherapp.api;

import com.android.volley.Response;

import org.json.JSONObject;

import javax.inject.Singleton;

@Singleton
public interface WeatherApiService {
    void getWeatherData(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);

    void getHourlyForecast(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);

    void getWeeklyForecast(Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener);
}
