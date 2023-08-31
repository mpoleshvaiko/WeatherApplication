package com.mpol.weatherapp.ui;

import android.widget.ImageView;

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
}
