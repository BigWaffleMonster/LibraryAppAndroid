package com.waffle.libraryapp.data.repository

import androidx.lifecycle.LiveData
import com.waffle.libraryapp.data.api.RetrofitInstance
import com.waffle.libraryapp.data.dao.BookDao
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.data.utils.bookTypeApi
import retrofit2.Response

class BookRepository(private val bookDao: BookDao) {
  val getBooks: LiveData<List<Book>> = bookDao.getBooks()

  suspend fun addBook (book: Book) {
    bookDao.addBook(book)
  }

  suspend fun getBooksFromApi(): Response<bookTypeApi> {
    return RetrofitInstance.api.getBooks()
  }
}