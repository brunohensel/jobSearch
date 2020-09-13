package com.example.jobsearch.api

import com.example.jobsearch.model.JobOffer
import retrofit2.http.GET

interface ApiService {

    @GET("positions")
    suspend fun getJobOffers(): JobOffer
}