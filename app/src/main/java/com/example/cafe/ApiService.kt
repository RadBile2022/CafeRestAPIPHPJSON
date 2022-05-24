package com.example.cafe

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService{
    var BASE_URL : String = "http://192.168.16.1/cafe/"

    val endpoint : ApiEndPoint

    get(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiEndPoint::class.java)


    }
}