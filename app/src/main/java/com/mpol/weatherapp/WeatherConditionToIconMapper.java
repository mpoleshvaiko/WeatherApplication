package com.mpol.weatherapp;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditionToIconMapper {
    private static final Map<String, Integer> lightConditionToIconMap = new HashMap<>();
    private static final Map<String, Integer> darkConditionToIconMap = new HashMap<>();

    static {
        lightConditionToIconMap.put("Sunny", R.drawable.ic_sunny_light);
        lightConditionToIconMap.put("Partly cloudy", R.drawable.ic_day_partly_cloudy_light);
        lightConditionToIconMap.put("Cloudy", R.drawable.ic_cloudy_light);
        lightConditionToIconMap.put("Overcast", R.drawable.ic_overcast_light);
        lightConditionToIconMap.put("Mist", R.drawable.ic_fog_light);
        lightConditionToIconMap.put("Patchy rain possible", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Patchy snow possible", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Patchy sleet possible", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Patchy freezing drizzle possible", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Thundery outbreaks possible", R.drawable.ic_thunder_light);
        lightConditionToIconMap.put("Blowing snow", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Blizzard", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Fog", R.drawable.ic_fog_light);
        lightConditionToIconMap.put("Freezing fog", R.drawable.ic_fog_cloudy_light);
        lightConditionToIconMap.put("Patchy light drizzle", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Light drizzle", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Freezing drizzle", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Heavy freezing drizzle", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Patchy light rain", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Light rain", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Moderate rain at times", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Moderate rain", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Heavy rain at times", R.drawable.ic_heavy_rain_light);
        lightConditionToIconMap.put("Heavy rain", R.drawable.ic_heavy_rain_light);
        lightConditionToIconMap.put("Light freezing rain", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Moderate or heavy freezing rain", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Light sleet", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Moderate or heavy sleet", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Patchy light snow", R.drawable.ic_snow_sun_light);
        lightConditionToIconMap.put("Light snow", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Patchy moderate snow", R.drawable.ic_snow_sun_light);
        lightConditionToIconMap.put("Moderate snow", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Patchy heavy snow", R.drawable.ic_snow_sun_light);
        lightConditionToIconMap.put("Heavy snow", R.drawable.ic_heavy_snow_light);
        lightConditionToIconMap.put("Ice pellets", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Light rain shower", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Moderate or heavy rain shower", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Torrential rain shower", R.drawable.ic_moderate_rain_light);
        lightConditionToIconMap.put("Light sleet showers", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Moderate or heavy sleet showers", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Light snow showers", R.drawable.ic_moderate_snow_light);
        lightConditionToIconMap.put("Moderate or heavy snow showers", R.drawable.ic_heavy_snow_light);
        lightConditionToIconMap.put("Light showers of ice pellets", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Moderate or heavy showers of ice pellets", R.drawable.ic_freezing_rain_light);
        lightConditionToIconMap.put("Patchy light rain with thunder", R.drawable.ic_thunder_rain_light);
        lightConditionToIconMap.put("Moderate or heavy rain with thunder", R.drawable.ic_thunder_rain_light);
        lightConditionToIconMap.put("Patchy light snow with thunder", R.drawable.ic_thunder_light);
        lightConditionToIconMap.put("Moderate or heavy snow with thunder", R.drawable.ic_thunder_light);

        darkConditionToIconMap.put("Sunny", R.drawable.ic_sunny_dark);
        darkConditionToIconMap.put("Partly cloudy", R.drawable.ic_day_partly_cloudy_dark);
        darkConditionToIconMap.put("Cloudy", R.drawable.ic_cloudy_dark);
        darkConditionToIconMap.put("Overcast", R.drawable.ic_overcast_dark);
        darkConditionToIconMap.put("Mist", R.drawable.ic_fog_dark);
        darkConditionToIconMap.put("Patchy rain possible", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Patchy sleet possible", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Patchy snow possible", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Patchy freezing drizzle possible", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Thundery outbreaks possible", R.drawable.ic_thunder_dark);
        darkConditionToIconMap.put("Blowing snow", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Blizzard", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Fog", R.drawable.ic_fog_dark);
        darkConditionToIconMap.put("Freezing fog", R.drawable.ic_fog_cloudy_dark);
        darkConditionToIconMap.put("Patchy light drizzle", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Light drizzle", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Freezing drizzle", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Heavy freezing drizzle", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Patchy light rain", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Light rain", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Moderate rain at times", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Moderate rain", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Heavy rain at times", R.drawable.ic_heavy_rain_dark);
        darkConditionToIconMap.put("Heavy rain", R.drawable.ic_heavy_rain_dark);
        darkConditionToIconMap.put("Light freezing rain", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy freezing rain", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Light sleet", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy sleet", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Patchy light snow", R.drawable.ic_snow_sun_dark);
        darkConditionToIconMap.put("Light snow", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Patchy moderate snow", R.drawable.ic_snow_sun_dark);
        darkConditionToIconMap.put("Moderate snow", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Patchy heavy snow", R.drawable.ic_snow_sun_dark);
        darkConditionToIconMap.put("Heavy snow", R.drawable.ic_heavy_snow_dark);
        darkConditionToIconMap.put("Ice pellets", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Light rain shower", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy rain shower", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Torrential rain shower", R.drawable.ic_moderate_rain_dark);
        darkConditionToIconMap.put("Light sleet showers", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy sleet showers", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Light snow showers", R.drawable.ic_moderate_snow_dark);
        darkConditionToIconMap.put("Moderate or heavy snow showers", R.drawable.ic_heavy_snow_dark);
        darkConditionToIconMap.put("Light showers of ice pellets", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy showers of ice pellets", R.drawable.ic_freezing_rain_dark);
        darkConditionToIconMap.put("Patchy light rain with thunder", R.drawable.ic_thunder_rain_dark);
        darkConditionToIconMap.put("Moderate or heavy rain with thunder", R.drawable.ic_thunder_rain_dark);
        darkConditionToIconMap.put("Patchy light snow with thunder", R.drawable.ic_thunder_dark);
        darkConditionToIconMap.put("Moderate or heavy snow with thunder", R.drawable.ic_thunder_dark);
    }

    public static int getIconResourceForCondition(String condition, boolean isDarkMode) {
        Map<String, Integer> iconMap = isDarkMode ? lightConditionToIconMap : darkConditionToIconMap;
        Integer iconResource = iconMap.get(condition);
        return iconResource != null ? iconResource : (isDarkMode ? R.drawable.ic_default_light : R.drawable.ic_default_dark);
    }
}
