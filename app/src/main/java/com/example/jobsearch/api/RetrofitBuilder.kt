package com.example.jobsearch.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**Objects declaration in kotlin means that we are creating a Singleton*/
object RetrofitBuilder {
    private const val BASE_URL = "https://jobs.github.com/"

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    val apiService: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }

}