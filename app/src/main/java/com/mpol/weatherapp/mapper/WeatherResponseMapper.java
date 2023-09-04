package com.mpol.weatherapp.mapper;

import static com.mpol.weatherapp.mapper.WeatherConditionToIconMapper.getIconResourceForCondition;

import com.mpol.weatherapp.model.DayWeatherData;
import com.mpol.weatherapp.model.HourlyForecastWeatherData;
import com.mpol.weatherapp.model.WeeklyForecastWeatherData;
import com.mpol.weatherapp.util.DateFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WeatherResponseMapper {

    public static DayWeatherData mapDayResponse(JSONObject response, boolean isDarkMode) throws JSONException {
        JSONObject currentObject = response.getJSONObject("current");
        JSONObject locationObject = response.getJSONObject("location");
        JSONObject forecastObject = response.getJSONObject("forecast");
        JSONObject forecastDayObject = forecastObject.getJSONArray("forecastday").getJSONObject(0).getJSONObject("day");

        String temperature = currentObject.getString("temp_c");
        String localTime = locationObject.getString("localtime");
        String iconText = currentObject.getJSONObject("condition").getString("text");
        Integer icon = getIconResourceForCondition(iconText, isDarkMode);
        String windSpeed = currentObject.getString("wind_mph");
        String humidity = currentObject.getString("humidity");
        Integer isDay = currentObject.getInt("is_day");
        String maxTemperature = forecastDayObject.getString("maxtemp_c");
        String minTemperature = forecastDayObject.getString("mintemp_c");

        return new DayWeatherData(localTime, temperature, icon, iconText, windSpeed, humidity, isDay, maxTemperature, minTemperature);
    }

    public static List<HourlyForecastWeatherData> mapHourlyForecastResponse(JSONObject response, boolean isDarkMode) throws JSONException {
        ArrayList<HourlyForecastWeatherData> hourlyForecastWeatherDataList = new ArrayList<>();
        JSONObject forecastDayObject = response.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0);
        JSONArray hourlyDataArray = forecastDayObject.getJSONArray("hour");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm", Locale.UK);

        for (int i = 0; i < hourlyDataArray.length(); i++) {
            JSONObject hourlyDataObject = hourlyDataArray.getJSONObject(i);
            String rawTime = hourlyDataObject.getString("time");
            String localTime = DateFormatter.formatTime(rawTime, inputFormat, outputFormat);

            String temperature = hourlyDataObject.getString("temp_c");
            Integer isDay = hourlyDataObject.getInt("is_day");
            String iconText = hourlyDataObject.getJSONObject("condition").getString("text");
            Integer icon = getIconResourceForCondition(iconText, isDarkMode);

            hourlyForecastWeatherDataList.add(new HourlyForecastWeatherData(localTime, temperature, icon, isDay));
        }
        return hourlyForecastWeatherDataList;
    }

    public static List<WeeklyForecastWeatherData> mapWeeklyForecastResponse(JSONObject response, boolean isDarkMode) throws JSONException {
        ArrayList<WeeklyForecastWeatherData> weeklyForecastWeatherDataList = new ArrayList<>();
        JSONArray forecastArray = response.getJSONObject("forecast").getJSONArray("forecastday");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE", Locale.getDefault());

        for (int i = 0; i < forecastArray.length(); i++) {
            JSONObject weeklyDataObject = forecastArray.getJSONObject(i);
            JSONObject dayForecastObject = weeklyDataObject.getJSONObject("day");
            JSONObject conditionForecastObject = dayForecastObject.getJSONObject("condition");

            String rawDate = weeklyDataObject.getString("date");
            String date = DateFormatter.formatDate(rawDate, inputFormat, outputFormat);
            String maxTemperature = dayForecastObject.getString("maxtemp_c");
            String minTemperature = dayForecastObject.getString("mintemp_c");
            String avgTemperature = dayForecastObject.getString("avgtemp_c");
            String iconText = conditionForecastObject.getString("text");
            Integer icon = getIconResourceForCondition(iconText, isDarkMode);

            weeklyForecastWeatherDataList.add(new WeeklyForecastWeatherData(date, avgTemperature, icon, minTemperature, maxTemperature));
        }

        return weeklyForecastWeatherDataList;
    }
}
