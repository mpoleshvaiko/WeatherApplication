package com.mpol.weatherapp.ui;

import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;

import com.mpol.weatherapp.R;

public class BindingAdapters {

    @BindingAdapter(value = {"app:weatherConditionIcon"})
    public static void setWeatherIcon(ImageView imageView, Integer iconResource) {
        if (iconResource != null) {
            imageView.setImageResource(iconResource);
        } else {
            imageView.setImageResource(R.drawable.ic_default);
        }
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
