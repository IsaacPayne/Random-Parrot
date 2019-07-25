package com.isaac.randomparrot

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    val webservice: ParrotApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .client(httpClient)
            .build().create(ParrotApi::class.java)
    }

    private val httpClient: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY }
            builder.addInterceptor(loggingInterceptor)
        }

        builder.build()
    }
}