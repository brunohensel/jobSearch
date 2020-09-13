package com.example.jobsearch.presentation

import androidx.lifecycle.ViewModel
import com.example.jobsearch.repository.JobRepository

class MainViewModel : ViewModel() {

    fun techJobOffers(){
        JobRepository.fetchJobOffers()
    }

    fun disposeCoroutineJob(){
        JobRepository.disposeCoroutineJob()
    }
}