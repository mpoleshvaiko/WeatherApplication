package com.mpol.weatherapp.model;

public class ForecastWeatherData {
    private String localTime;
    private String temperature;
    private Integer icon;

    private Integer isDay;

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public ForecastWeatherData(
            String localTime,
            String temperature,
            Integer icon,
            Integer isDay
    ) {
        this.localTime = localTime;
        this.temperature = temperature;
        this.icon = icon;
        this.isDay = isDay;
    }
}
