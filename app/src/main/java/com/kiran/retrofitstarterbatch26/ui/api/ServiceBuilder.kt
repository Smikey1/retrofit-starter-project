package com.kiran.retrofitstarterbatch26.ui.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL="http://10.0.2.2:3000/api/v1/"
    var token:String? = null

    // create a OkHttp Client instance
    private val oKHttp=OkHttpClient.Builder().build()

    // create a retrofit builder
    private  val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(oKHttp)

    // retrofit instance from retrofit builder
    private val retrofit = retrofitBuilder.build()


    // create a generic function which implement a class and return retrofit instance/object of respective class
    fun <T> buildService(anyClass:Class<T>):T {
        return retrofit.create(anyClass)
    }

}