package com.example.randommovieapp.app

import android.app.Application
import com.example.randommovieapp.di.appModule
import com.example.randommovieapp.di.dataModule
import com.example.randommovieapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RandomMovieApp: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin{
      androidContext(this@RandomMovieApp)
      modules(dataModule, domainModule, appModule)
    }
  }
}