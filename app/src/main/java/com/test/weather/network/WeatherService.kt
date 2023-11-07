package com.test.weather.network

import com.test.weather.BuildConfig
import com.test.weather.data.WeatherSearchResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") q:String,
        @Query("days") days: Int,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherSearchResponse

    companion object{
        fun create(): WeatherService {
            val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(CustomHeaderInterceptor("key", BuildConfig.API_KEY))
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(WeatherService::class.java)
        }
    }
}