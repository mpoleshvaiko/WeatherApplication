package com.mpol.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherResponseMapper {
    public static WeatherData mapResponse(JSONObject response) throws JSONException {
        JSONObject currentObject = response.getJSONObject("current");
        JSONObject locationObject = response.getJSONObject("location");
        JSONObject forecastObject = response.getJSONObject("forecast");
        JSONObject forecastDayObject = forecastObject.getJSONArray("forecastday").getJSONObject(0).getJSONObject("day");
        String temperature = currentObject.getString("temp_c");
        String localTime = locationObject.getString("localtime");
        String icon = currentObject.getJSONObject("condition").getString("icon");
        String iconText = currentObject.getJSONObject("condition").getString("text");
        String windSpeed = currentObject.getString("wind_mph");
        String humidity = currentObject.getString("humidity");
        Integer isDay = currentObject.getInt("is_day");
        String maxTemperature = forecastDayObject.getString("maxtemp_c");
        String minTemperature = forecastDayObject.getString("mintemp_c");

        return new WeatherData(localTime, temperature, icon, iconText, windSpeed, humidity, isDay, maxTemperature, minTemperature);
    }
}
