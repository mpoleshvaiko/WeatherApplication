package com.mpol.weatherapp;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditionToIconMapper {
    private static final Map<String, Integer> conditionToIconMap = new HashMap<>();

    static {
        conditionToIconMap.put("Sunny", R.drawable.ic_sun_light);
        conditionToIconMap.put("Partly cloudy", R.drawable.ic_partly_cloudy_light);
        conditionToIconMap.put("Cloudy", R.drawable.ic_cloud_light);
        conditionToIconMap.put("Overcast", R.drawable.ic_overcast_light);
        conditionToIconMap.put("Mist", R.drawable.ic_fog_mist_light);
        conditionToIconMap.put("Patchy rain possible", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Patchy snow possible", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Patchy sleet possible", R.drawable.ic_sleet_light);
        conditionToIconMap.put("Patchy freezing drizzle possible", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Thundery outbreaks possible", R.drawable.ic_thunder_weather_light);
        conditionToIconMap.put("Blowing snow", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Blizzard", R.drawable.ic_snow_light);
        conditionToIconMap.put("Fog", R.drawable.ic_fog_mist_light);
        conditionToIconMap.put("Freezing fog", R.drawable.ic_fog_mist_light);
        conditionToIconMap.put("Patchy light drizzle", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Light drizzle", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Freezing drizzle", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Heavy freezing drizzle", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Patchy light rain", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Light rain", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Moderate rain at times", R.drawable.ic_moderate_rain_light);
        conditionToIconMap.put("Moderate rain", R.drawable.ic_moderate_rain_light);
        conditionToIconMap.put("Heavy rain at times", R.drawable.ic_heavy_rain_light);
        conditionToIconMap.put("Heavy rain", R.drawable.ic_heavy_rain_light);
        conditionToIconMap.put("Light freezing rain", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Moderate or heavy freezing rain", R.drawable.ic_heavy_rain_light);
        conditionToIconMap.put("Light sleet", R.drawable.ic_sleet_light);
        conditionToIconMap.put("Moderate or heavy sleet", R.drawable.ic_sleet_light);
        conditionToIconMap.put("Patchy light snow", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Light snow", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Patchy moderate snow", R.drawable.ic_snow_light);
        conditionToIconMap.put("Moderate snow", R.drawable.ic_snow_light);
        conditionToIconMap.put("Patchy heavy snow", R.drawable.ic_snow_light);
        conditionToIconMap.put("Heavy snow", R.drawable.ic_snow_light);
        conditionToIconMap.put("Ice pellets", R.drawable.ic_snow_light);
        conditionToIconMap.put("Light rain shower", R.drawable.ic_light_rain_light);
        conditionToIconMap.put("Moderate or heavy rain shower", R.drawable.ic_moderate_rain_light);
        conditionToIconMap.put("Torrential rain shower", R.drawable.ic_moderate_rain_light);
        conditionToIconMap.put("Light sleet showers", R.drawable.ic_sleet_light);
        conditionToIconMap.put("Moderate or heavy sleet showers", R.drawable.ic_sleet_light);
        conditionToIconMap.put("Light snow showers", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Moderate or heavy snow showers", R.drawable.ic_snow_light);
        conditionToIconMap.put("Light showers of ice pellets", R.drawable.ic_light_snow_light);
        conditionToIconMap.put("Moderate or heavy showers of ice pellets", R.drawable.ic_snow_light);
        conditionToIconMap.put("Patchy light rain with thunder", R.drawable.ic_thunder_weather_light);
        conditionToIconMap.put("Moderate or heavy rain with thunder", R.drawable.ic_thunder_weather_light);
        conditionToIconMap.put("Patchy light snow with thunder", R.drawable.ic_thunder_weather_light);
        conditionToIconMap.put("Moderate or heavy snow with thunder", R.drawable.ic_thunder_weather_light);
    }

    public static int getIconResourceForCondition(String condition) {
        Integer iconResource = conditionToIconMap.get(condition);
        return iconResource != null ? iconResource : R.drawable.ic_default;
    }
}
