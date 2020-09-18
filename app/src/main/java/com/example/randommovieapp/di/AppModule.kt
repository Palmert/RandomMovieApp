package com.example.randommovieapp.di

import com.example.randommovieapp.movie.RandomMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { RandomMovieViewModel(get()) }
}