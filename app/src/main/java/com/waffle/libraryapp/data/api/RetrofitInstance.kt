package com.waffle.libraryapp.data.api

import com.waffle.libraryapp.data.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
  private val retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val api: BookApi by lazy {
    retrofit.create(BookApi::class.java)
  }
}