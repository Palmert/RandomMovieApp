package com.example.randommovieapp.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.randommovieapp.R
import com.example.randommovieapp.databinding.ActivityRandomMovieBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

  private val viewModel: RandomMovieViewModel by inject()

  private val binding: ActivityRandomMovieBinding by lazy {
    DataBindingUtil.setContentView<ActivityRandomMovieBinding>(this, R.layout.activity_random_movie)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.viewModel = viewModel
  }
}