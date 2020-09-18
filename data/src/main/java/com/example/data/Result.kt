package com.example.data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.http.promisesBody

inline fun <reified T: Any> OkHttpClient.performRequest(request: Request): Result<T>  {
  return this.newCall(request).execute().let {
    when {
      it.isSuccessful && it.promisesBody() -> Result.Success(
          Gson().fromJson(it.body!!.string(), T::class.java))
      else -> Result.Failure(Exception("Unable to parse response"))
    }
  }
}

sealed class Result<out T : Any> {
  data class Success<out T : Any>(val data: T) : Result<T>()
  data class Failure(val exception: Throwable) : Result<Nothing>()
}