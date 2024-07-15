package com.example.rangtechnologygauravassignment.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory.*


class ApiClient private constructor() {
    companion object {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Set the desired logging level
        }
        val retrofit: Retrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Retrofit.Builder()
                .baseUrl("http://ax.itunes.apple.com/")// with your API base URL
                .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
                .addConverterFactory(create())
                .build()
        }
    }
}