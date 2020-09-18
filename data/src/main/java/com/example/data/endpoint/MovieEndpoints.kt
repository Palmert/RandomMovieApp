package com.example.data.endpoint

enum class MovieEndpoints(val url: String) {
  GET_RANDOM_MOVIE("https://api.reelgood.com/v1/roulette/netflix?nocache=true&kind=2&minimumScore=4&availability=onAnySource")
}