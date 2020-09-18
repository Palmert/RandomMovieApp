package com.example.randommovieapp.di

import com.example.data.gateway.MovieGateway
import com.example.data.gateway.RemoteMovieGateway
import com.example.data.repository.MovieRepository
import com.example.data.repository.MovieRepositoryImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module

val dataModule = module {
  single { OkHttpClient() }

  single<MovieGateway> { RemoteMovieGateway(get()) }

  single<MovieRepository> { MovieRepositoryImpl(get()) }
}