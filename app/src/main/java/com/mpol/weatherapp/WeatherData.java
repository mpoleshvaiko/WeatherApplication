package com.mpol.weatherapp;

public class WeatherData {
    private String localTime;
    private String currentTemperature;
    private Integer icon;
    private String iconText;
    private String windSpeed;
    private String humidity;

    private Integer isDay;

    private String maxTemperature;
    private String minTemperature;

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getIconText() {
        return iconText;
    }

    public void setIconText(String iconText) {
        this.iconText = iconText;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public WeatherData(
            String localTime,
            String currentTemperature,
            Integer icon,
            String iconText,
            String windSpeed,
            String humidity,
            Integer isDay,
            String maxTemperature,
            String minTemperature
    ) {
        this.localTime = localTime;
        this.currentTemperature = currentTemperature;
        this.icon = icon;
        this.iconText = iconText;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.isDay = isDay;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }
}
