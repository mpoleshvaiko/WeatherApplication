package com.mpol.weatherapp.api;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class VolleySingleton {

    private final RequestQueue requestQueue;

    @Inject
    public VolleySingleton(@ApplicationContext Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
