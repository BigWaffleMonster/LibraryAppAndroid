package com.waffle.libraryapp.data.api

import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.data.utils.bookTypeApi
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
  @GET("works/OL45883W.json")
  suspend fun getBooks(): Response<bookTypeApi>
}