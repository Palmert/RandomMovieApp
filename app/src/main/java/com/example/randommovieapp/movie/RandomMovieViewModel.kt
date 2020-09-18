package com.example.randommovieapp.movie


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetRandomMovieUseCase
import com.example.domain.GetRandomMovieUseCase.Result.Movie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RandomMovieViewModel(
    private val getRandomMovieUseCase: GetRandomMovieUseCase
) : ViewModel() {
  val title = ObservableField("")
  val rating = ObservableField("")
  val overview = ObservableField("")

  init {
    getRandomMovie()
  }

  fun refreshMovie() {
    getRandomMovie()
  }

  private fun getRandomMovie() {
    viewModelScope.launch(IO) {
      handleMovieResult(getRandomMovieUseCase.execute())
    }
  }

  private fun handleMovieResult(movie: GetRandomMovieUseCase.Result) {
    if (movie is Movie) {
      title.set(movie.title)
      rating.set(movie.rating)
      overview.set(movie.overview)
    }
  }
}