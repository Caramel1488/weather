package com.test.weather.main

import android.content.Context
import com.google.gson.Gson
import com.test.weather.data.WeatherSearchResponse
import com.test.weather.network.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class MainRepository(
    private val context: Context
) {

    private val fileName = "test.txt"

    suspend fun getForecast(q: String): WeatherSearchResponse {
        return withContext(Dispatchers.IO) {
            try {
                val response = WeatherService.create().getForecast(q, 5)
                writeData(Gson().toJson(response))
                response
            }catch (e:Throwable){
                e.printStackTrace()
                Gson().fromJson(readData(), WeatherSearchResponse::class.java)
            }
        }
    }

    fun writeData(data: String){
        try {
            val file = File(context.filesDir, fileName)
            val outputStream = file.outputStream()
            outputStream.write(data.toByteArray())
            outputStream.close()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }
    fun readData():String{
        return try {
            val fin: FileInputStream = File(context.filesDir, fileName).inputStream()
            val temp = fin.bufferedReader().use {
                it.readText()
            }
            fin.close()
            temp
        }catch (e:IOException){
            e.printStackTrace()
            "nah"
        }
    }
}