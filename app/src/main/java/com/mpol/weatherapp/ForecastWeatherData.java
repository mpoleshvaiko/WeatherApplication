package com.mpol.weatherapp;

public class ForecastWeatherData {
    private String localTime;
    private String currentTemperature;
    private Integer icon;
    private String iconText;

    private Integer isDay;

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

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public ForecastWeatherData(
            String localTime,
            String currentTemperature,
            Integer icon,
            String iconText,
            Integer isDay
    ) {
        this.localTime = localTime;
        this.currentTemperature = currentTemperature;
        this.icon = icon;
        this.iconText = iconText;
        this.isDay = isDay;
    }
}
