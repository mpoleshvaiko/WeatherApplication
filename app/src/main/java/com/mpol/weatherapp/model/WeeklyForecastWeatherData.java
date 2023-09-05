package com.mpol.weatherapp.model;

public class WeeklyForecastWeatherData {

    private String date;
    private String avgTemperature;
    private Integer icon;
    private String minTemperature;
    private String maxTemperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(String avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
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


    public WeeklyForecastWeatherData(
            String date,
            String avgTemperature,
            Integer icon,
            String minTemperature,
            String maxTemperature
    ) {
        this.date = date;
        this.avgTemperature = avgTemperature;
        this.icon = icon;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }
}
