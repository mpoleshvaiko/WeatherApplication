package com.mpol.weatherapp.model;

public class ForecastWeatherData {
    private String localTime;
    private String temperature;
    private Integer icon;
    private String iconText;

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
            String temperature,
            Integer icon,
            String iconText,
            Integer isDay
    ) {
        this.localTime = localTime;
        this.temperature = temperature;
        this.icon = icon;
        this.iconText = iconText;
        this.isDay = isDay;
    }
}
