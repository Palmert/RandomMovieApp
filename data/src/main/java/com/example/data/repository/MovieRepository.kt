package com.example.data.repository

import com.example.data.gateway.MovieGateway
import com.example.data.response.MovieResponse
import com.example.data.Result


interface MovieRepository {
  suspend fun getRandomMovie(): Result<MovieResponse>
}

class MovieRepositoryImpl(private val gateway: MovieGateway): MovieRepository {
  override suspend fun getRandomMovie(): Result<MovieResponse> {
    return gateway.getRandomMovie()
  }
}