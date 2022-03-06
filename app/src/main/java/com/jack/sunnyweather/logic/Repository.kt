package com.jack.sunnyweather.logic

import androidx.lifecycle.liveData
import com.jack.sunnyweather.logic.model.Place
import com.jack.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponce = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResponce.status == "ok"){
                val places = placeResponce.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponce.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}