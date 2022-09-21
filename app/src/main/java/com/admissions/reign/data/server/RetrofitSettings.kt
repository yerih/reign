package com.admissions.reign.data.server

import com.google.gson.GsonBuilder
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitSettings {

    companion object{

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(OkHttpProfilerInterceptor())
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()

        private val gson = GsonBuilder().setLenient().create()

        fun builder(baseUrl: String): Retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }
}
