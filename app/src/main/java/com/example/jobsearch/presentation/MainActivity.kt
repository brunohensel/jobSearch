package com.example.jobsearch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jobsearch.R

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    viewModel.fetchJobOffers().observe(this, Observer { jobs ->
      println("DEBUG: $jobs")
    })
  }

  override fun onDestroy() {
    viewModel.disposeCoroutineJob()
    super.onDestroy()
  }
}