package com.example.jobsearch.repository

import androidx.lifecycle.LiveData
import com.example.jobsearch.api.RetrofitBuilder
import com.example.jobsearch.model.JobOffer
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object JobRepository  {

    var coroutineJob: CompletableJob? = null

    fun fetchJobOffers(): LiveData<JobOffer>{
        coroutineJob = Job()
        return object : LiveData<JobOffer>(){
            override fun onActive() {
                super.onActive()
                coroutineJob?.let {coroutineJob ->
                    CoroutineScope(IO + coroutineJob).launch {
                        val jobOffer = RetrofitBuilder.apiService.getJobOffers()
                        withContext(Main){
                            value = jobOffer
                            coroutineJob.complete()
                        }
                    }

                }
            }
        }
    }

    fun disposeCoroutineJob(){
        coroutineJob?.cancel()
    }
}