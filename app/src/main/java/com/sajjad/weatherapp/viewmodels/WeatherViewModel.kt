package com.sajjad.weatherapp.viewmodels

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajjad.weatherapp.models.CurrentModel
import com.sajjad.weatherapp.models.ForecastModel
import com.sajjad.weatherapp.repos.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    val repository = WeatherRepository()
    val locationLiveData : MutableLiveData<Location> = MutableLiveData()
    val currentLiveData : MutableLiveData<CurrentModel> = MutableLiveData()
    val forecastLiveData : MutableLiveData<ForecastModel> = MutableLiveData()

    fun setNewLocation(location: Location){
        locationLiveData.value = location
    }
    fun fetchData(status: Boolean) {
        viewModelScope.launch {
            try {
                currentLiveData.value = repository.fetchCurrentData(locationLiveData.value!!, status)
                forecastLiveData.value = repository.fetchForecastData(locationLiveData.value!!, status)
            }catch (e: Exception) {
                Log.d("WeatherViewModel", e.localizedMessage)
            }
        }
    }
}