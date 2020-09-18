package com.example.randommovieapp

import com.example.domain.GetRandomMovieUseCase
import com.example.domain.GetRandomMovieUseCase.Result.Movie
import com.example.randommovieapp.movie.RandomMovieViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class RandomMovieViewModelTest {
  private val getRandomMovieUseCase = mockk<GetRandomMovieUseCase>()
  private val initialMovie =
      Movie("A title", "A Rating", "An overview")

  private lateinit var sut: RandomMovieViewModel

  @Before
  fun setup() {
    coEvery { getRandomMovieUseCase.execute() } returns initialMovie
    sut = RandomMovieViewModel(getRandomMovieUseCase)
  }

  @Test
  fun `should set the movie title from the initial random movie`() {
    coVerify { getRandomMovieUseCase.execute() }

    assertEquals(sut.title.get(), initialMovie.title)
  }

  @Test
  fun `should set the movie rating from the initial random movie`() {
    coVerify { getRandomMovieUseCase.execute() }

    assertEquals(sut.rating.get(), initialMovie.rating)
  }

  @Test
  fun `should set the movie overview from the initial random movie`() {
    coVerify { getRandomMovieUseCase.execute() }

    assertEquals(sut.overview.get(), initialMovie.overview)
  }

  @Test
  fun `should get a new random movie when the user presses refresh`() {
    val newRandomMovie =
        Movie("A New Title", "A New Rating", "A New Overview")


    coEvery { getRandomMovieUseCase.execute() } returns newRandomMovie

    sut.refreshMovie()

    coVerify { getRandomMovieUseCase.execute() }
    // Tests should only verify one thing but I think this is clear for an example.
    assertEquals(sut.title.get(), newRandomMovie.title)
    assertEquals(sut.overview.get(), newRandomMovie.overview)
    assertEquals(sut.rating.get(), newRandomMovie.rating)
  }
}