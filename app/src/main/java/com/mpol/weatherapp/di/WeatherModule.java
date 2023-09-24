package com.mpol.weatherapp.di;

import com.mpol.weatherapp.api.WeatherApiService;
import com.mpol.weatherapp.api.WeatherApiServiceImpl;
import com.mpol.weatherapp.repository.WeatherDataRepository;
import com.mpol.weatherapp.repository.WeatherDataRepositoryImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class WeatherModule {
    @Singleton
    @Binds
    public abstract WeatherApiService bindWeatherApiService(WeatherApiServiceImpl weatherApiService);

    @Singleton
    @Binds
    public abstract WeatherDataRepository bindWeatherRepository(WeatherDataRepositoryImpl weatherRepository);
}
