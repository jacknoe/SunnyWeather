package com.jack.sunnyweather.logic.network

import com.jack.sunnyweather.SunnyWeatherApplication
import com.jack.sunnyweather.logic.model.PlaceResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String):Call<PlaceResponce>
}