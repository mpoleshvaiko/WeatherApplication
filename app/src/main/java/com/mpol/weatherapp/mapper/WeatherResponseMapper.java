package com.mpol.weatherapp.mapper;

import static com.mpol.weatherapp.mapper.WeatherConditionToIconMapper.getIconResourceForCondition;

import com.mpol.weatherapp.model.DayWeatherData;
import com.mpol.weatherapp.model.HourlyForecastWeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            String localTime = formatTime(rawTime, inputFormat, outputFormat);

            String temperature = hourlyDataObject.getString("temp_c");
            Integer isDay = hourlyDataObject.getInt("is_day");
            String iconText = hourlyDataObject.getJSONObject("condition").getString("text");
            Integer icon = getIconResourceForCondition(iconText, isDarkMode);

            hourlyForecastWeatherDataList.add(new HourlyForecastWeatherData(localTime, temperature, icon, isDay));
        }
        return hourlyForecastWeatherDataList;
    }

    private static String formatTime(
            String rawTime,
            SimpleDateFormat inputFormat,
            SimpleDateFormat outputFormat
    ) {
        try {
            Date date = inputFormat.parse(rawTime);
            assert date != null;
            String formatted = outputFormat.format(date);
            return formatted.substring(0, formatted.length() - 3);
        } catch (ParseException e) {
            return rawTime;
        }
    }
}
