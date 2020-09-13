package com.example.jobsearch.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**Objects declaration in kotlin means that we are creating a Singleton*/
object RetrofitBuilder {
    private const val BASE_URL = "https://jobs.github.com/"

    val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiString: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }

}