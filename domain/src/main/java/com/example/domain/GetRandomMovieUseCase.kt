package com.example.domain

import com.example.data.Result.Success
import com.example.data.repository.MovieRepository

class GetRandomMovieUseCase(private val movieRepository: MovieRepository) {

  sealed class Result {
    data class Movie(val title: String, val rating: String, val overview: String) : Result()
    object UnableToGetMovie: Result()
  }

  suspend fun execute() : Result {
    return movieRepository.getRandomMovie().let {
      when (it) {
        is Success -> Result.Movie(it.data.title, it.data.imdb_rating, it.data.overview)
        else -> Result.UnableToGetMovie
      }
    }
  }
}