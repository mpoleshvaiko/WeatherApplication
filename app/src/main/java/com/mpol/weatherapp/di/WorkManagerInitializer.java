package com.mpol.weatherapp.di;

import static java.util.Collections.emptyList;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.WorkManager;

import com.mpol.weatherapp.BuildConfig;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class WorkManagerInitializer implements Initializer<WorkManager> {

    @NonNull
    @Provides
    @Singleton
    @Override
    public WorkManager create(@NonNull @ApplicationContext Context context) {
        WorkManagerInitializerEntryPoint entryPoint = EntryPointAccessors
                .fromApplication(
                        context,
                        WorkManagerInitializerEntryPoint.class
                );

        Configuration configuration = new Configuration.Builder()
                .setWorkerFactory(entryPoint.hiltWorkerFactory())
                .setMinimumLoggingLevel(BuildConfig.DEBUG ? Log.DEBUG : Log.INFO)
                .build();
        WorkManager.initialize(context, configuration);
        return WorkManager.getInstance(context);
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return emptyList();
    }

    @InstallIn(SingletonComponent.class)
    @EntryPoint
    interface WorkManagerInitializerEntryPoint {
        HiltWorkerFactory hiltWorkerFactory();
    }
}
