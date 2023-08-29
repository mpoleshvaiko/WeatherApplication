package com.mpol.weatherapp;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("app:weatherConditionIcon")
    public static void setWeatherIcon(ImageView imageView, Integer iconResource) {
        if (iconResource != null) {
            imageView.setImageResource(iconResource);
        } else {
            imageView.setImageResource(R.drawable.ic_default);
        }
    }
}
