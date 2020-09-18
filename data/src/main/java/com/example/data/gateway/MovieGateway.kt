package com.example.data.gateway

import com.example.data.Result
import com.example.data.endpoint.MovieEndpoints
import com.example.data.performRequest
import com.example.data.response.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.Request

interface MovieGateway {
  fun getRandomMovie(): Result<MovieResponse>
}

class RemoteMovieGateway(private val client: OkHttpClient): MovieGateway {
  override fun getRandomMovie(): Result<MovieResponse> {
    val request = Request.Builder()
        .url(MovieEndpoints.GET_RANDOM_MOVIE.url)
        .build()
    return client.performRequest(request)
  }
}
