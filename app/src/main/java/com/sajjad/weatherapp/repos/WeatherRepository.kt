package com.sajjad.weatherapp.repos

import android.location.Location
import android.util.Log
import com.sajjad.weatherapp.NetworkService
import com.sajjad.weatherapp.models.CurrentModel
import com.sajjad.weatherapp.models.ForecastModel
import com.sajjad.weatherapp.weather_api_key

class WeatherRepository {
    suspend fun fetchCurrentData(location: Location,status: Boolean): CurrentModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl =
            "weather?lat=${location.latitude}&lon=${location.longitude}&units=$unit&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getCurrentWeather(endUrl)
    }
    suspend fun fetchForecastData(location: Location, status: Boolean): ForecastModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl =
            "forecast?lat=${location.latitude}&lon=${location.longitude}&units=$unit&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getForecastWeather(endUrl)
    }
}