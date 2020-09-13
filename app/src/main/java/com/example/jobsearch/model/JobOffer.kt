package com.example.jobsearch.model

data class JobOffer(val jobs: ArrayList<JobItem>)

data class JobItem(
    val company: String,
    val company_logo: String?,
    val description: String,
    val location: String,
    val title: String,
    val type: String
)