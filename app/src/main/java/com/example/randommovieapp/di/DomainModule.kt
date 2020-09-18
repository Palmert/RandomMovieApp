package com.example.randommovieapp.di

import com.example.domain.GetRandomMovieUseCase
import org.koin.dsl.module

val domainModule = module {
  single { GetRandomMovieUseCase(get())}
}