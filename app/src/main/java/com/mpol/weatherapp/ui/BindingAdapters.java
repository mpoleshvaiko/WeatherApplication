package com.mpol.weatherapp.ui;

import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;

import com.mpol.weatherapp.R;

public class BindingAdapters {

    @BindingAdapter(value = {"app:weatherConditionIcon", "app:isDarkMode"})
    public static void setWeatherIcon(ImageView imageView, Integer iconResource, boolean isDarkMode) {
        int defaultIcon = isDarkMode ? R.drawable.ic_default_light : R.drawable.ic_default_dark;
        if (iconResource != null) {
            imageView.setImageResource(iconResource);
        } else {
            imageView.setImageResource(defaultIcon);
        }
    }

    @BindingAdapter("app:isDarkMode")
    public static void setSearchIcon(ImageView imageView, boolean isDarkMode) {
        int defaultIcon = isDarkMode ? R.drawable.ic_search_light : R.drawable.ic_search_dark;
        imageView.setImageResource(defaultIcon);
    }

    @BindingAdapter("app:hourlyForecastIcon")
    public static void setHourlyForecastIcon(ImageView imageView, Integer iconResource) {
        imageView.setImageResource(iconResource);
    }

    @BindingAdapter("app:dailyForecastIcon")
    public static void setDailyForecastIcon(ImageView imageView, Integer iconResource) {
        imageView.setImageResource(iconResource);
    }

    @BindingAdapter("app:progressFromTemperatureText")
    public static void setProgressFromTemperatureText(ProgressBar progressBar, String text) {
        try {
            float progressValue = Float.parseFloat(text);
            progressBar.setProgress((int) progressValue);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
