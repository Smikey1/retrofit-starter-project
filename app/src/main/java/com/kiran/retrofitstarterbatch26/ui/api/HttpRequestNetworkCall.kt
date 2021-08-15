package com.kiran.retrofitstarterbatch26.ui.api

import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.lang.StringBuilder

abstract class HttpRequestNetworkCall {
    suspend fun <T> myHttpRequestNetworkCall(anyFunction:suspend()->Response<T>):T{
        val response = anyFunction.invoke()
        if (response.isSuccessful){
            return response.body()!!
        } else {
            ///////// Error Handeling ............................!!!!
            val errorMessage = response.errorBody()?.string()
            val errorCode = "Error code: ${response.code()}"
            throw IOException("Error message: $errorMessage and \n Error code: $errorCode")
        }
    }
}
