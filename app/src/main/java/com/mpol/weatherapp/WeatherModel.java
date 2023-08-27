package com.mpol.weatherapp;

public class WeatherModel {
    private String localTime;
    private String currentTemperature;
    private String icon;
    private String iconText;
    private String windSpeed;
    private String humidity;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
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

    public WeatherModel(
            String localTime,
            String currentTemperature,
            String icon,
            String iconText,
            String windSpeed,
            String humidity
    ) {
        this.localTime = localTime;
        this.currentTemperature = currentTemperature;
        this.icon = icon;
        this.iconText = iconText;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }
}
